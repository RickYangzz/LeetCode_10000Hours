package BM25_二叉树的后序遍历.java_solutions;

import java.util.ArrayList;
import java.util.Stack;

public class StackSolution {
    public int[] postorderTraversal (TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<Object> stack = new Stack<>();
        
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root.val);
                if(root.right != null) stack.push(root.right);
                root = root.left;
            }

            Object topNode = stack.pop();
            
            if(topNode instanceof Integer){
                result.add((Integer) topNode);
            } else {
                root = (TreeNode) topNode;
            }
        }

        return convertToIntArray(result);
    }

    private int[] convertToIntArray(ArrayList<Integer> list) {
        if(list == null || list.size() == 0) return new int[0];

        int[] arr = new int[list.size()];
        for(int i = 0; i < list.size();i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
}
