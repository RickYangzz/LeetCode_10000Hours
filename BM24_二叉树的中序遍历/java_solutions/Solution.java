package BM24_二叉树的中序遍历.java_solutions;
import java.util.ArrayList;

public abstract class Solution {
    /**
     * 
     * @param root TreeNode类 
     * @return int整型一维数组
     */
    abstract int[] inorderTraversal(TreeNode root);

    protected int[] convertToIntArray(ArrayList<Integer> list) {
        if(list == null || list.size() == 0) return new int[0];

        int[] arr = new int[list.size()];
        for(int i = 0; i < list.size();i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
}