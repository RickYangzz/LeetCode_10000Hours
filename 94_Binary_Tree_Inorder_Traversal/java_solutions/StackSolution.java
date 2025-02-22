import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackSolution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        Stack<TreeNode> stack = new Stack<>();

        while(root != null || !stack.empty()){
            while(root != null){
                stack.add(root);
                root = root.left;
            }

            TreeNode top = stack.pop();
            result.add(top.val);
            root = top.right;
        }

        return result;
    }
}
