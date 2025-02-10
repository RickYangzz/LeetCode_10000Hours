package BM73_最长回文子串.java_solutions;

public class Solution {
    public int getLongestPalindrome (String A) {
        if(A.length() == 0) return 0;
        if(A.length() == 1) return 1;

        int result = 1;
        for (int i = 1; i < A.length(); i++) {
            int currentLength = Math.max(diffusion(A, i-1, i), diffusion(A, i, i));
            result = Math.max(result, currentLength);
        }

        return result;
    }

    private int diffusion(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }

        return right - left - 1;
    }
}