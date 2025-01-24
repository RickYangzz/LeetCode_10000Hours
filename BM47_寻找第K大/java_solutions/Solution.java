package BM47_寻找第K大.java_solutions;

import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param a int整型一维数组 
     * @param n int整型 
     * @param K int整型 
     * @return int整型
     */
    public int findKth (int[] a, int n, int K) {
        return quickSort(a, 0, n-1, K);
    }

    private int quickSort(int[] a, int low, int high, int k){
        int splitSpot = partition(a, low, high);

        if(splitSpot + 1 == k) {
            return a[splitSpot];
        }else if(splitSpot + 1 < k) {
            return quickSort(a, splitSpot+1, high, k);
        }else{
            return quickSort(a, low, splitSpot-1, k);
        }
    }

    private int partition(int[] a, int low, int high){
        int splitValue = a[low];
        
        while(low < high) {
            while (low < high && a[high] < splitValue) {
                high--;
            }
            a[low] = a[high];
            while(low<high && a[low]>=splitValue){
                low++;
            }
            a[high] = a[low];
        }

        a[low] = splitValue;
        return low;
    }
}