package BM73_最长回文子串.java_solutions;

public class Manacher {
    public int getLongestPalindrome (String A) {
        int[] mp = new int[2*A.length() + 2];

        calculate(A, mp);

        int maxLen = 0;
        for (int i = 0; i < mp.length; i++) {
            maxLen = Math.max(maxLen, mp[i] -1);
        }
        return maxLen;
    }

    private void calculate(String A, int[] mp){
        String ms  = "$#";
        for (int i = 0; i < A.length(); i++) {
            ms += A.charAt(i);
            ms += "#";
        }

        int rightSide = 0;
        int maxIndex = 0;

        for (int i = 0; i < ms.length(); i++) {
            mp[i] = rightSide > i ? Math.min(mp[2*maxIndex - i], rightSide - i) : 1;
            while(
                i - mp[i] >= 0 && 
                i + mp[i] < ms.length() && 
                ms.charAt(i - mp[i]) == ms.charAt(i + mp[i])
            ){
                mp[i] += 1;
            }

            if(i + mp[i] > rightSide){
                rightSide = i + mp[i];
                maxIndex = i;
            }
        }
    }
}
