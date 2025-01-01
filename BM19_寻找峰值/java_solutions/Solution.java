public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param nums int整型一维数组
     * @return int整型
     */
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while(start < end){
            int mid = (start + end) / 2;

            if (nums[mid] < nums[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;
    }
}