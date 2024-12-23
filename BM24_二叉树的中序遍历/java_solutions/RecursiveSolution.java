package BM24_二叉树的中序遍历.java_solutions;
import java.util.*;

public class RecursiveSolution extends Solution {
    public int[] inorderTraversal (TreeNode root) {
        if(root == null) return new int[0];

        ArrayList<Integer> res = new ArrayList<>();
        
        inorderTraversalHelper(root, res);

        return convertToIntArray(res);
    }

    private void inorderTraversalHelper (TreeNode root, ArrayList<Integer> res) {
        if(root.left != null) inorderTraversalHelper(root.left, res);
        res.add(root.val);
        if(root.right != null) inorderTraversalHelper(root.right, res);
    }
}