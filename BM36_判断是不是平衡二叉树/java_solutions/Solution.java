package BM36_判断是不是平衡二叉树.java_solutions;

import java.util.*;

public class Solution {
    Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param pRoot TreeNode类 
     * @return bool布尔型
     */
    public boolean IsBalanced_Solution (TreeNode pRoot) {
        calculateHeight(pRoot);
        return judge(pRoot);
    }

    private int calculateHeight(TreeNode root){
        if(root == null) return 0;

        int leftHeight = calculateHeight(root.left);
        int rightHeight = calculateHeight(root.right);
        int rootHeight = Math.max(leftHeight, rightHeight) + 1;

        map.put(root, rootHeight);
        return rootHeight;
    }

    private boolean judge(TreeNode root){
        if(root == null) return true;

        int leftHeight = root.left != null ? map.get(root.left) : 0;
        int rightHeght = root.right != null ? map.get(root.right) : 0;

        boolean result = Math.abs(leftHeight - rightHeght) <= 1;

        return result && judge(root.left) && judge(root.right);
    }
}