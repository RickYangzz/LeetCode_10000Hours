package BM24_二叉树的中序遍历.java_solutions;

import java.util.ArrayList;
import java.util.Stack;

public class StackSolution extends Solution {
    public int[] inorderTraversal (TreeNode root) {
        if(root == null) return new int[0];
        
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Object> stack = new Stack<>(); 

        stack.push(root);
        while (!stack.isEmpty()) {
            Object top = stack.pop();
            if(top instanceof Integer) {
                res.add((Integer) top);
                continue;
            }

            TreeNode topNode = (TreeNode) top;

            if(topNode.right != null) stack.push(topNode.right);
            if(topNode.left == null) {
                res.add(topNode.val);
            } else {
                stack.push(topNode.val);
                stack.push(topNode.left);
            }
        }

        return convertToIntArray(res);
    }
}
