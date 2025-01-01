public class RecursionSolution {
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

        return recursion(nums, start, end);
    }

    private int recursion(int[] nums, int start, int end) {
        if (start == end)
            return start;
        if (start+1 == end) 
            return nums[start] > nums[end] ? start: end;

        int mid = (start + end) / 2;

        if (nums[mid] < nums[mid + 1])
            start = mid + 1;
        else if (nums[mid - 1] > nums[mid])
            end = mid-1;
        else 
            return mid;

        return recursion(nums, start, end);
    }
}