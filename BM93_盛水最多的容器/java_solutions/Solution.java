package BM93_盛水最多的容器.java_solutions;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param height int整型一维数组 
     * @return int整型
     */
    public int maxArea (int[] height) {
        int max = 0;

        int left = 0 ;
        int right = height.length - 1;

        while(left < right){
            int capacity = (right - left) * Math.min(height[left], height[right]);
            if (capacity > max) max = capacity;

            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }

        return max;
    }
}