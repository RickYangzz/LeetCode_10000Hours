package BM36_判断是不是平衡二叉树.java_solutions;

public class BestSolution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param pRoot TreeNode类 
     * @return bool布尔型
     */
    public boolean IsBalanced_Solution (TreeNode pRoot) {
        int result = calculateHeight(pRoot);
        return result != -1;
    }

    private int calculateHeight(TreeNode root){
        if(root == null) return 0;

        int leftHeight = calculateHeight(root.left);
        if(leftHeight == -1) return -1;
        int rightHeight = calculateHeight(root.right);
        if(rightHeight == -1) return -1;

        boolean result = Math.abs(leftHeight - rightHeight) <= 1;
        if(result) {
            return Math.max(leftHeight, rightHeight) + 1;
        } else {
            return -1;
        }
    }
}
