package BM25_二叉树的后序遍历.java_solutions;

import java.util.ArrayList;

public class RecursiveSolution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param root TreeNode类 
     * @return int整型一维数组
     */
    public int[] postorderTraversal (TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        postorderTraversalHelper(root, result);

        return convertToIntArray(result);
    }

    private void postorderTraversalHelper(TreeNode root, ArrayList<Integer> result) {
        if(root == null) return;

        postorderTraversalHelper(root.left, result);
        postorderTraversalHelper(root.right, result);
        result.add(root.val);
    }

    private int[] convertToIntArray(ArrayList<Integer> list) {
        if(list == null || list.size() == 0) return new int[0];

        int[] arr = new int[list.size()];
        for(int i = 0; i < list.size();i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
}