package BM25_二叉树的后序遍历.java_solutions;

import java.util.Arrays;

public class SolutionTest {
    public static void main(String[] args) {
        // Test Case 1: A simple binary tree with 3 nodes (Root, Left, Right)
        System.out.println("Test Case 1:");
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        runTest(root1, new int[]{2, 3, 1});

        // Test Case 2: A binary tree with only one node (root only)
        System.out.println("Test Case 2:");
        TreeNode root2 = new TreeNode(1);
        runTest(root2, new int[]{1});

        // Test Case 3: A binary tree where the root has only a left child
        System.out.println("Test Case 3:");
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        runTest(root3, new int[]{2, 1});

        // Test Case 4: A binary tree where the root has only a right child
        System.out.println("Test Case 4:");
        TreeNode root4 = new TreeNode(1);
        root4.right = new TreeNode(2);
        runTest(root4, new int[]{2, 1});

        // Test Case 5: A more complex tree with multiple levels (Root, Left and Right Children, and further children)
        System.out.println("Test Case 5:");
        TreeNode root5 = new TreeNode(1);
        root5.left = new TreeNode(2);
        root5.right = new TreeNode(3);
        root5.left.left = new TreeNode(4);
        root5.left.right = new TreeNode(5);
        root5.right.left = new TreeNode(6);
        root5.right.right = new TreeNode(7);
        runTest(root5, new int[]{4, 5, 2, 6, 7, 3, 1});

        // Test Case 6: An empty tree (null root)
        System.out.println("Test Case 6:");
        TreeNode root6 = null;
        runTest(root6, new int[]{});
    }
    
    // Run tests for all three solutions and compare expected with real result
    private static void runTest(TreeNode root, int[] expected) {
        StackSolution stackSolution = new StackSolution();
        int[] result = stackSolution.postorderTraversal(root);
        compareResults("StackSolution", result, expected);

        RecursiveSolution recursiveSolution = new RecursiveSolution();
        result = recursiveSolution.postorderTraversal(root);
        compareResults("RecursiveSolution", result, expected);

        BetterStackSolution betterStackSolution = new BetterStackSolution();
        result = betterStackSolution.postorderTraversal(root);
        compareResults("BetterStackSolution", result, expected);

        System.out.println();  // Newline between test cases
    }
    
    // Compare expected and real results, print "pass" or "failed"
    private static void compareResults(String solutionName, int[] result, int[] expected) {
        if (Arrays.equals(result, expected)) {
            System.out.println(solutionName + " passed");
        } else {
            System.out.println(solutionName + " failed");
            System.out.println("Expected: " + Arrays.toString(expected));
            System.out.println("Got: " + Arrays.toString(result));
        }
    }
}

