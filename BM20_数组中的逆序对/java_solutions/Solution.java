package BM20_数组中的逆序对.java_solutions;

public class Solution {
    int count = 0;

    /**
     * 
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
     * 输入一个数组,求出这个数组中的逆序对的总数P。
     * 并将P对1000000007取模的结果输出。 即输出P mod 1000000007
     *
     * 
     * @param nums int整型一维数组
     * @return int整型
     */
    public int InversePairs(int[] nums) {
        if (nums.length < 2)
            return 0;

        count = 0;
        mergeSort(nums, 0, nums.length - 1);
        return count;
    }

    private void mergeSort(int[] nums, int start, int end) {
        if (start >= end)
            return;

        int middle = (start + end) / 2;
        // left
        mergeSort(nums, start, middle);
        // right
        mergeSort(nums, middle + 1, end);
        // combine
        merge(nums, start, middle, end);
    }

    private void merge(int[] nums, int start, int middle, int end) {
        int[] arrTemp = new int[end - start + 1];

        int i = 0;
        int l = start;
        int r = middle + 1;

        while (l <= middle && r <= end) {
            if (nums[l] < nums[r]) {
                arrTemp[i] = nums[l];
                l++;
                i++;
            } else {
                arrTemp[i] = nums[r];

                this.count += middle - l + 1;
                this.count %= 1000000007;

                r++;
                i++;
            }
        }

        while (l <= middle) {
            arrTemp[i] = nums[l];
            l++;
            i++;
        }

        while (r <= end) {
            arrTemp[i] = nums[r];
            r++;
            i++;
        }

        for (int index = 0; index < arrTemp.length; index++) {
            nums[start + index] = arrTemp[index];
        }
    }
}