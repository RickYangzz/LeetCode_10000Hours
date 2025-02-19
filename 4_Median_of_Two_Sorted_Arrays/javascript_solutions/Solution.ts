function findMedianSortedArrays(nums1: number[], nums2: number[]): number {
    const m = nums1.length;
    const n = nums2.length;

    if(m > n) return findMedianSortedArrays(nums2, nums1);

    const partitionSize = Math.floor((m+n+1)/2);
    let left = 0;
    let right = m;

    while(left <= right){
        const firstMiddle = Math.floor((left + right) / 2);
        const secondMiddle = partitionSize - firstMiddle;

        const firstLeft = firstMiddle-1 >= 0 ? nums1[firstMiddle-1] : Number.MIN_SAFE_INTEGER;
        const firstRight = firstMiddle < m ? nums1[firstMiddle] : Number.MAX_SAFE_INTEGER;
        const secondLeft = secondMiddle-1 >= 0 ? nums2[secondMiddle-1] : Number.MIN_SAFE_INTEGER;
        const secondRight = secondMiddle < n ? nums2[secondMiddle] : Number.MAX_SAFE_INTEGER;

        if(firstLeft <= secondRight && secondLeft <= firstRight){
            if((m+n)%2 == 1){
                return Math.max(firstLeft, secondLeft);
            }else{
                return (Math.max(firstLeft, secondLeft) + Math.min(firstRight, secondRight)) / 2
            }
        }else if(firstLeft > secondRight){
            right = firstMiddle - 1;
        }else{
            left = firstMiddle + 1;
        }
    }

    return 0;
};