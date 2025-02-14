function findJudge(n: number, trust: number[][]): number {
    const count = new Array(n+1).fill(0);

    for (const arr of trust) {
        count[arr[0]] -= 1;
        count[arr[1]] += 1;
    }

    for (let i = 1; i < count.length; i++) {
        if(count[i] == n-1) return i;
    }

    return -1;
};