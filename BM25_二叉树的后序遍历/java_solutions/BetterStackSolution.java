package BM25_二叉树的后序遍历.java_solutions;

import java.util.ArrayList;
import java.util.Stack;

public class BetterStackSolution {
    public int[] postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            TreeNode topNode = stack.pop();

            if (topNode.right == null || topNode.right == pre) {
                result.add(topNode.val);
                pre = topNode;
                continue;
            } else {
                stack.push(topNode);
                root = topNode.right;
            }
        }

        return convertToIntArray(result);
    }

    private int[] convertToIntArray(ArrayList<Integer> list) {
        if (list == null || list.size() == 0)
            return new int[0];

        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
