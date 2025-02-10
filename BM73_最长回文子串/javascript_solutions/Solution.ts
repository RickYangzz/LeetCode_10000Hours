export function getLongestPalindrome(A: string): number {
    if(A.length == 0) return 0;
    if(A.length == 1) return 1;

    let result = 1;
    for (let i = 1; i < A.length; i++) {
        const currentLength = Math.max(diffusion(A, i-1, i), diffusion(A, i, i));
        result = Math.max(currentLength, result);
    }
    return result;
}

function diffusion(s: string, left: number, right: number): number{
    while(left >= 0 && right < s.length && s.charAt(left) == s.charAt(right)){
        left--;
        right++;
    }

    return right - left - 1;
}