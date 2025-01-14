package BM32_合并二叉树.java_solutions;

import java.util.LinkedList;

public class QueueSolution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return null;
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;

        LinkedList<TreeNode> q = new LinkedList<>();
        LinkedList<TreeNode> q1 = new LinkedList<>();
        LinkedList<TreeNode> q2 = new LinkedList<>();

        TreeNode head = new TreeNode(t1.val + t2.val);
        q.offer(head);
        q1.offer(t1);
        q2.offer(t2);

        while (q.size()>0 && q1.size() > 0 && q2.size() > 0) {
            TreeNode total = q.poll();
            TreeNode n1 = q1.poll();
            TreeNode n2 = q2.poll();

            if (n1.left != null && n2.left != null) {
                total.left = new TreeNode(n1.left.val + n2.left.val);

                q.offer(total.left);
                q1.offer(n1.left);
                q2.offer(n2.left);
            } else if (n1.left != null) {
                total.left = n1.left;
            } else if (n2.left != null) {
                total.left = n2.left;
            }

            if (n1.right != null && n2.right != null) {
                total.right = new TreeNode(n1.right.val + n2.right.val);

                q.offer(total.right);
                q1.offer(n1.right);
                q2.offer(n2.right);
            } else if (n1.right != null) {
                total.right = n1.right;
            } else if (n2.right != null) {
                total.right = n2.right;
            }
        }

        return head;
    }
}
