package BM40_重建二叉树.java_solutions;

import java.util.*;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param preOrder int整型一维数组 
     * @param vinOrder int整型一维数组 
     * @return TreeNode类
     */
    public TreeNode reConstructBinaryTree (int[] preOrder, int[] vinOrder) {
        if(preOrder.length == 0 || vinOrder.length == 0) return null;

        int rootVal = preOrder[0];

        TreeNode root = new TreeNode(rootVal);

        for (int i = 0; i < vinOrder.length; i++) {
            if(vinOrder[i] == rootVal){
                root.left = reConstructBinaryTree(
                    Arrays.copyOfRange(preOrder, 1, i+1), 
                    Arrays.copyOfRange(vinOrder, 0, i)
                );
                root.right = reConstructBinaryTree(
                    Arrays.copyOfRange(preOrder, i+1, preOrder.length), 
                    Arrays.copyOfRange(vinOrder, i+1, vinOrder.length)
                );
                break;
            }
        }

        return root;
    }
}