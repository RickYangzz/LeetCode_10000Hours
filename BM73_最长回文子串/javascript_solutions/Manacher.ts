export function getLongestPalindrome(A: string): number {
    const mp = new Array(A.length * 2 + 2);
    calculate(A, mp);

    let maxLen = 0;
    for (let i = 0; i < mp.length; i++) {
        maxLen = Math.max(maxLen, mp[i] - 1);
    }
    return maxLen;
}

function calculate(A, mp){
    let ms = '$#';
    for (let i = 0; i < A.length; i++) {
        ms += A.charAt(i);
        ms += "#";
    }

    let rightSide = 0;
    let index = 0;
    
    for (let i = 0; i < ms.length; i++) {
        mp[i] = rightSide > i ? Math.min(mp[2*index - i], rightSide - i) : 1;

        while(i - mp[i] >= 0 && i + mp[i] < ms.length && ms[i - mp[i]] == ms[i + mp[i]]){
            mp[i] += 1;
        }
        
        if(i + mp[i] > rightSide){
            rightSide = i + mp[i];
            index = i;
        }
    }
}