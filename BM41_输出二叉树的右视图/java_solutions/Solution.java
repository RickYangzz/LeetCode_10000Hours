package BM41_输出二叉树的右视图.java_solutions;

import java.util.*;

public class Solution {
    public int[] solve (int[] preOrder, int[] inOrder) {
        TreeNode root = buildTree(preOrder, inOrder);
        ArrayList<Integer> result = getRightView(root);

        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }

        return res;
    }

    private TreeNode buildTree(int[] preOrder, int[] inOrder){
        if(preOrder.length == 0 || inOrder.length == 0) return null;

        int rootVal = preOrder[0];
        TreeNode root = new TreeNode(rootVal);
        for (int i = 0; i < inOrder.length; i++) {
            if(inOrder[i] == rootVal){
                root.left = buildTree(
                    Arrays.copyOfRange(preOrder, 1, i+1), 
                    Arrays.copyOfRange(inOrder, 0, i)
                );
                root.right = buildTree(
                    Arrays.copyOfRange(preOrder, i+1, preOrder.length), 
                    Arrays.copyOfRange(inOrder, i+1, inOrder.length)
                );
                break;
            }
        }

        return root;
    }

    private ArrayList<Integer> getRightView(TreeNode root){
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            while(size > 0){
                TreeNode top = queue.poll();
                size--;
                if(top.left!=null) queue.add(top.left);
                if(top.right!=null) queue.add(top.right);
                if(size == 0){
                    result.add(top.val);
                }
            }
        }

        return result;
    }
}