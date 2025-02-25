function twoSum(nums: number[], target: number): number[] {
    const map: Map<number, number> = new Map<number, number>();

    for (let i = 0; i < nums.length; i++) {
        const complement = target - nums[i];
        if (map.has(complement)) {
            const firstIndex = map.get(complement);
            if (firstIndex == undefined) throw new Error("Data Error");
            return [firstIndex, i];
        }

        map.set(nums[i], i);
    }

    return [];
};