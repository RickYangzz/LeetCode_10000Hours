package BM35_判断是不是完全二叉树.java_solutions;

import java.util.*;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param root TreeNode类 
     * @return bool布尔型
     */
    public boolean isCompleteTree (TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Boolean isFinished = false;

        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode head = queue.poll();

            if(head == null){
                isFinished = true;
                continue;
            }

            if(isFinished){
                return false;
            }

            queue.offer(head.left);
            queue.offer(head.right);
        }

        return true;
    }
}