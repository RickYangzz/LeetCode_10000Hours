/**
 * Find the smallest missing positive integer in an array of integers
 *
 * @param nums Array of integers (can contain positive, negative, and zero)
 * @return The smallest positive integer that is missing from the array
 */
export function minNumberDisappeared(nums: number[]): number {
    const N = nums.length;

    // First iteration: replace all non-positive numbers (<=0) with N+1 
    // This ensures we only work with positive numbers in subsequent steps
    for (let index = 0; index < N; index++) {
        const value = nums[index];

        if(value <= 0) {
            nums[index] = N + 1;
        }
    }

    // Second iteration: mark presence of numbers by making nums[value-1] negative
    // If we see value x, we mark nums[x-1] as negative to indicate x exists
    for (let index = 0; index < N; index++) {
        const value = Math.abs(nums[index]);

        if(value <= N) {
            nums[value - 1] = -1 * Math.abs(nums[value - 1]);
        }
    }

    // Third iteration: find the first positive number's index
    // A positive number at index i means i+1 is the first missing positive integer
    for (let index = 0; index < N; index++) {
        const value = nums[index];

        if(value > 0) return index + 1;
    }

    return N + 1;
}
