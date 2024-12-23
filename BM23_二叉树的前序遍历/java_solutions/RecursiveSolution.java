package BM23_二叉树的前序遍历.java_solutions;
import java.util.ArrayList;

/**
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * 数据范围：二叉树的节点数量满足 1≤n≤100，二叉树节点的值满足 1≤val≤100，树的各节点的值各不相同
 */
public class RecursiveSolution {

    /**
     * @param root TreeNode类
     * @return int整型一维数组
     */
    public int[] preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        preorderTraversalHelper(root, result);
        return result.stream().mapToInt(Integer::intValue).toArray(); // Convert to int[]
    }

    // 改为使用一个共享的 List，避免创建多个临时列表：
    private void preorderTraversalHelper(TreeNode root, ArrayList<Integer> result) {
        if (root == null)
            return;

        result.add(root.val);
        preorderTraversalHelper(root.left, result);
        preorderTraversalHelper(root.right, result);
    }
}
