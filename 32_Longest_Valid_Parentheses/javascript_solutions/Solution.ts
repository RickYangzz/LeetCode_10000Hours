function longestValidParentheses(s: string): number {
    const dp = new Array(s.length).fill(0);
    let maxLength = 0;

    for (let i = 1; i < dp.length; i++) {
        if(s[i] == ')'){
            if(s[i-1] == '('){
                dp[i] = (i-2 >= 0 ? dp[i-2] : 0) + 2;
            }else if(i - dp[i-1] - 1 >= 0 && s[i-dp[i-1]-1] == '('){
                dp[i] = dp[i-1] + 2 + (i-dp[i-1]-2 >= 0 ? dp[i-dp[i-1]-2] : 0)
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
    }

    return maxLength;
};