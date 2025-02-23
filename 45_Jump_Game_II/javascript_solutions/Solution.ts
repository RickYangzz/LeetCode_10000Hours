function jump(nums: number[]): number {
    let near = 0, far = 0, jump = 0;

    while(far < nums.length -1){
        let farthest = 0;
        for (let i = near; i < far+1; i++) {
            farthest = Math.max(farthest, i+nums[i]);
        }

        near = far+1;
        far = farthest;
        jump += 1;
    }

    return jump;
};