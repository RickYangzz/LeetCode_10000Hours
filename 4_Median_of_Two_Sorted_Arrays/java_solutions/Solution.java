class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length; 
        int n = nums2.length;

        if(n<m) return findMedianSortedArrays(nums2, nums1);

        int partitionSize = (m+n+1) / 2;
        int left = 0;
        int right = m;

        while(left <= right){
            int firstMiddle = (left + right) / 2;
            int secondMiddle = partitionSize - firstMiddle;

            int firstLeft = firstMiddle-1 >= 0 ? nums1[firstMiddle-1] : Integer.MIN_VALUE;
            int firstRight = firstMiddle < m ? nums1[firstMiddle] : Integer.MAX_VALUE;
            int secondLeft = secondMiddle-1 >= 0 ? nums2[secondMiddle-1] : Integer.MIN_VALUE;
            int secondRight = secondMiddle < n ? nums2[secondMiddle] : Integer.MAX_VALUE;

            if(firstLeft<=secondRight && secondLeft<=firstRight){
                if((m+n) % 2 == 1){
                    return (double)Math.max(firstLeft, secondLeft) ;
                }else{
                    return (double)(Math.max(firstLeft,secondLeft) + Math.min(firstRight, secondRight)) / 2.0;
                }
            }else if(firstLeft > secondRight){
                right = firstMiddle - 1;
            }else{
                left = firstMiddle + 1;
            }
        }

        return 0;
    }
}