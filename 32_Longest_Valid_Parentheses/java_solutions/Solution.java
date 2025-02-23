import java.util.Arrays;

class Solution {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, 0);
        int maxLength = 0;

        for (int i = 1; i < dp.length; i++) {
            if(s.charAt(i) == ')') {
                if(s.charAt(i-1) == '('){
                    dp[i] = (i-2 >= 0 ? dp[i-2] : 0) + 2;
                }else if(i - dp[i-1] - 1 >= 0 && s.charAt(i - dp[i-1] - 1) == '('){
                    dp[i] = dp[i-1] + 2 + (i-dp[i-1]-2 >= 0 ? dp[i-dp[i-1]-2] : 0);
                }
                maxLength = Math.max(maxLength, dp[i]);
            }
        }

        return maxLength;
    }
}