package BM30_二叉搜索树与双向链表.java_solutions;

public class RecursionSolution {
    private TreeNode head = null;
    private TreeNode pre = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;

        Convert(pRootOfTree.left);

        if(head == null) {
            head = pRootOfTree;
            pre = pRootOfTree;
        } else {
            pre.right = pRootOfTree;
            pRootOfTree.left = pre;
            pre = pRootOfTree;
        }

        Convert(pRootOfTree.right);

        return head;
    }
}
