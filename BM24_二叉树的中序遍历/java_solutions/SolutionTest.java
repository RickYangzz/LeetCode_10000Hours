package BM24_二叉树的中序遍历.java_solutions;

import java.util.*;

public class SolutionTest {

    public static void main(String[] args) {
        // 创建所有的实现类
        List<Solution> solutions = Arrays.asList(
                new RecursiveSolution(),
                new StackSolution(),
                new BetterStackSolution());

        // 对每一个Solution进行测试
        for (Solution solution : solutions) {
            System.out.println("Testing with solution: " + solution.getClass().getSimpleName());

            // Test Case 1: Empty tree
            TreeNode root1 = null;
            int[] result1 = solution.inorderTraversal(root1);
            int[] expected1 = {};
            System.out.println("Test Case 1: " + (Arrays.equals(result1, expected1) ? "passed" : "failed"));

            // Test Case 2: Single node tree
            TreeNode root2 = new TreeNode(1);
            int[] result2 = solution.inorderTraversal(root2);
            int[] expected2 = { 1 };
            System.out.println("Test Case 2: " + (Arrays.equals(result2, expected2) ? "passed" : "failed"));

            // Test Case 3: Left-skewed tree
            TreeNode root3 = new TreeNode(3);
            root3.left = new TreeNode(2);
            root3.left.left = new TreeNode(1);
            int[] result3 = solution.inorderTraversal(root3);
            int[] expected3 = { 1, 2, 3 };
            System.out.println("Test Case 3: " + (Arrays.equals(result3, expected3) ? "passed" : "failed"));

            // Test Case 4: Right-skewed tree
            TreeNode root4 = new TreeNode(1);
            root4.right = new TreeNode(2);
            root4.right.right = new TreeNode(3);
            int[] result4 = solution.inorderTraversal(root4);
            int[] expected4 = { 1, 2, 3 };
            System.out.println("Test Case 4: " + (Arrays.equals(result4, expected4) ? "passed" : "failed"));

            // Test Case 5: Full binary tree
            TreeNode root5 = new TreeNode(4);
            root5.left = new TreeNode(2);
            root5.right = new TreeNode(6);
            root5.left.left = new TreeNode(1);
            root5.left.right = new TreeNode(3);
            root5.right.left = new TreeNode(5);
            root5.right.right = new TreeNode(7);
            int[] result5 = solution.inorderTraversal(root5);
            int[] expected5 = { 1, 2, 3, 4, 5, 6, 7 };
            System.out.println("Test Case 5: " + (Arrays.equals(result5, expected5) ? "passed" : "failed"));

            // Test Case 6: Mixed tree
            TreeNode root6 = new TreeNode(5);
            root6.left = new TreeNode(3);
            root6.right = new TreeNode(8);
            root6.left.left = new TreeNode(1);
            root6.left.right = new TreeNode(4);
            root6.right.left = new TreeNode(7);
            int[] result6 = solution.inorderTraversal(root6);
            int[] expected6 = { 1, 3, 4, 5, 7, 8 };
            System.out.println("Test Case 6: " + (Arrays.equals(result6, expected6) ? "passed" : "failed"));

            System.out.println(); // 为了分隔每种实现的结果
        }
    }
}
