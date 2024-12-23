package BM24_二叉树的中序遍历.java_solutions;

import java.util.ArrayList;
import java.util.Stack;

public class BetterStackSolution extends Solution{
    public int[] inorderTraversal(TreeNode root) {
        if (root == null)
            return new int[0];

        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode top = stack.pop();
            res.add(top.val);
            root = top.right;
        }

        return convertToIntArray(res);
    }
}
