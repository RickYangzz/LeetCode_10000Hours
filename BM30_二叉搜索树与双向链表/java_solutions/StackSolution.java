package BM30_二叉搜索树与双向链表.java_solutions;

import java.util.Stack;

public class StackSolution {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        
        TreeNode head = null;
        TreeNode pre = null;

        Stack<TreeNode> stack = new Stack<TreeNode>();

        while(!stack.isEmpty() || pRootOfTree != null){
            while(pRootOfTree != null){
                stack.push(pRootOfTree);
                pRootOfTree = pRootOfTree.left;
            }

            TreeNode top = stack.pop();

            if(head == null){
                head = top;
                pre = top;
            } else {
                pre.right = top;
                top.left = pre;
                pre = top;
            }

            pRootOfTree = top.right;
        }

        return head;
    }
}
