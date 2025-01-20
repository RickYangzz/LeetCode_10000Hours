package BM33_二叉树的镜像.java_solutions;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param pRoot TreeNode类 
     * @return TreeNode类
     */
    public TreeNode Mirror (TreeNode pRoot) {
        if(pRoot == null) return null;

        TreeNode left = pRoot.left;
        TreeNode right = pRoot.right;

        pRoot.right = left;
        pRoot.left = right;

        Mirror(left);
        Mirror(right);

        return pRoot;
    }
}