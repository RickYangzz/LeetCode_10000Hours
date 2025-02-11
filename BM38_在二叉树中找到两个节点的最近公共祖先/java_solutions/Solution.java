package BM38_在二叉树中找到两个节点的最近公共祖先.java_solutions;

import java.util.*;

public class Solution {
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        ArrayList<Integer> pathA = new ArrayList<>();
        ArrayList<Integer> pathB = new ArrayList<>();

        dfs(root, o1, pathA);
        dfs(root, o2, pathB);

        int i = 0;
        while(pathA.size() > i && pathB.size() > i){
            if(pathA.get(i).equals(pathB.get(i))){
                i++;
            } else {
                break;
            }
        }

        return pathA.get(i-1);
    }

    private boolean dfs(TreeNode root, int target, ArrayList<Integer> path){
        if(root == null) return false;

        path.add(root.val);

        if(root.val == target) {
            return true;
        }

        boolean left = dfs(root.left, target, path);
        boolean right = dfs(root.right, target, path);

        if(left || right){
            return true;
        }

        path.remove(path.size()-1);
        return false;
    }
}