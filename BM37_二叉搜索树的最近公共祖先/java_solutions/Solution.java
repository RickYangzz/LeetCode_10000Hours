package BM37_二叉搜索树的最近公共祖先.java_solutions;

import java.util.*;

public class Solution {
    public int lowestCommonAncestor(TreeNode root, int p, int q) {
        ArrayList<Integer> pPath = getTargetPath(root, p);
        ArrayList<Integer> qPath = getTargetPath(root, q);

        int x = 0;
        while (x < pPath.size() && x < qPath.size()) {
            if (pPath.get(x).equals(qPath.get(x))) {
                x++;
            } else {
                break;
            }
        }

        return pPath.get(x - 1);
    }

    private ArrayList<Integer> getTargetPath(TreeNode root, int target) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        while (root.val != target) {
            result.add(root.val);

            if (target > root.val) {
                root = root.right;
            } else {
                root = root.left;
            }
        }

        result.add(root.val);

        return result;
    }
}