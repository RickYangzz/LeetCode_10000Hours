package BM85_验证IP地址.java_solutions;

public class Solution {
    /**
     * 编写一个函数来验证输入的字符串是否是有效的 IPv4 或 IPv6 地址
     *
     * 验证IP地址
     * @param IP string字符串 一个IP地址字符串
     * @return string字符串
     */
    public String solve (String IP) {
        if(isIPv4(IP))  return "IPv4";
        if(isIPv6(IP))  return "IPv6";
        
        return "Neither";
    }

    /**
     * IPv4 地址由十进制数和点来表示，每个地址包含4个十进制数，其范围为 0 - 255， 用(".")分割。
     * 比如，172.16.254.1；
     * 
     * 同时，IPv4 地址内的数不会以 0 开头。
     * 比如，地址 172.16.254.01 是不合法的。
     * 
     * @param IP
     * @return
     */
    private boolean isIPv4(String IP){
        if(!IP.contains(".")) return false;

        String[] arr = IP.split("\\.", -1);

        if(arr.length != 4) return false;

        for (String subString : arr) {
            // 长度不能为0 或者 超过3
            if(subString.length() == 0 || subString.length()>3) return false;
            // 不能以0开头
            if(subString.startsWith("0") && subString.length() > 1) return false;

            int value = 0;
            for (char c : subString.toCharArray()) {
                if(c < '0' || c > '9') return false;

                value = value * 10 + (int)(c-'0');
                if(value > 255 || value < 0) return false;
            }
        }

        return true;
    }

    /**
     * IPv6 地址由8组16进制的数字来表示，每组表示 16 比特。这些组数字通过 (":")分割。
     * 比如,  2001:0db8:85a3:0000:0000:8a2e:0370:7334 是一个有效的地址。
     * 而且，我们可以加入一些以 0 开头的数字，字母可以使用大写，也可以是小写。
     * 所以， 2001:db8:85a3:0:0:8A2E:0370:7334 也是一个有效的 IPv6 address地址 (即，忽略 0 开头，忽略大小写)。
     * 
     * 然而，我们不能因为某个组的值为 0，而使用一个空的组，以至于出现 (::) 的情况。 
     * 比如， 2001:0db8:85a3::8A2E:0370:7334 是无效的 IPv6 地址。
     * 
     * 同时，在 IPv6 地址中，多余的 0 也是不被允许的。
     * 比如， 02001:0db8:85a3:0000:0000:8a2e:0370:7334 是无效的。
     * 
     * @param IP
     * @return
     */
    private boolean isIPv6(String IP) {
        if(!IP.contains(":")) return false;

        String[] arr = IP.split(":", -1); 

        if(arr.length != 8) return false;

        for (String subString : arr) {
            if(subString.length() == 0 || subString.length() > 4) return false;

            for (char c : subString.toCharArray()) {
                if(!is0F(c)) return false;
            }
        }


        return true;
    }

    private boolean is0F(char c){
        return (c>='0' && c<='9') || (c>='a' && c<='f') || (c>='A' && c<='F');
    }
}