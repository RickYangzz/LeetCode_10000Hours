package BM69_把数字翻译成字符串.java_solutions;

import java.util.*;

public class Solution {
    /**
     * 有一种将字母编码成数字的方式：'a'->1, 'b->2', ... , 'z->26'。
     * 现在给一串数字，返回有多少种可能的译码结果
     *
     * 解码
     * @param nums string字符串 数字串
     * @return int整型
     */
    public int solve (String nums) {
        if(nums.equals("0")) return 0;

        int[] dp = new int[nums.length()+1];
        Arrays.fill(dp, 1);

        for (int i = 2; i <= nums.length(); i++) {
            if(nums.charAt(i-1) == '0' && nums.charAt(i-2) != '1' && nums.charAt(i-2) != '2'){
                return 0;
            }

            if( nums.charAt(i-1) == '0' && ( nums.charAt(i-2) == '1' || nums.charAt(i-2) == '2' )){
                dp[i] = dp[i-2];
                continue;
            }

            if( 
                ( nums.charAt(i-2) == '1' && '0' < nums.charAt(i-1) ) || 
                ( nums.charAt(i-2) == '2' && '0' < nums.charAt(i-1) && nums.charAt(i-1) < '7' )
            ){
                dp[i] = dp[i-1] + dp[i-2];
                continue;
            }

            dp[i] = dp[i-1];
        }

        return dp[nums.length()];
    }
}