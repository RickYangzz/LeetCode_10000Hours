package BM23_二叉树的前序遍历.java_solutions;

import java.util.ArrayList;
import java.util.Stack;

public class StackSolution {
    /**
     * @param root TreeNode类
     * @return int整型一维数组
     */
    public int[] preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode topNode = stack.pop();
            if (topNode == null)
                continue;
            
            result.add(topNode.val);
            stack.push(topNode.right);
            stack.push(topNode.left);
        }

        return convertToIntArray(result);
    }

    private int[] convertToIntArray(ArrayList<Integer> list) {
        int[] arr = new int[list.size()];
        for(int i = 0; i < list.size();i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
}
