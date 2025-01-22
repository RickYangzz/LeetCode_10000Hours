package BM34_判断是不是二叉搜索树.java_solutions;

public class Solution {
    int pre = Integer.MIN_VALUE;
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param root TreeNode类 
     * @return bool布尔型
     */
    public boolean isValidBST (TreeNode root) {
        if(root == null) return true;

        if(!isValidBST(root.left)) return false;
        if(root.val < pre) return false;

        pre = root.val;

        return isValidBST(root.right);
    }
}