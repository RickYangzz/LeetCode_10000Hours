package BM23_二叉树的前序遍历.java_solutions;
import java.util.Arrays;

public class SolutionTest {
    private static void runTest(String testName, TreeNode root, int[] expected) {
        RecursiveSolution recursiveSolution = new RecursiveSolution();
        StackSolution stackSolution = new StackSolution();
    
        int[] recursiveResult = recursiveSolution.preorderTraversal(root);
        int[] stackResult = stackSolution.preorderTraversal(root);
    
        System.out.println("Test Case: " + testName);
        System.out.println("Expected output: " + Arrays.toString(expected));
    
        System.out.println("recursive Solution output: " + Arrays.toString(recursiveResult));
        System.out.println("Stack Solution output:     " + Arrays.toString(stackResult));
    
        boolean recursivePass = Arrays.equals(recursiveResult, expected);
        boolean stackPass = Arrays.equals(stackResult, expected);
    
        System.out.println("recursive Solution Status: " + (recursivePass ? "PASSED" : "FAILED"));
        System.out.println("Stack Solution Status:     " + (stackPass ? "PASSED" : "FAILED"));
    
        if (recursivePass != stackPass) {
            System.out.println("Warning: Solutions produce different results!");
        }
    
        System.out.println("----------------------------------------");
    }

    public static void main(String[] args) {
        // 测试用例1: 完全二叉树
        //       1
        //     /   \
        //    2     3
        //   / \   / \
        //  4   5 6   7
        TreeNode test1 = new TreeNode(1);
        test1.left = new TreeNode(2);
        test1.right = new TreeNode(3);
        test1.left.left = new TreeNode(4);
        test1.left.right = new TreeNode(5);
        test1.right.left = new TreeNode(6);
        test1.right.right = new TreeNode(7);
        
        // 测试用例2: 左偏树
        //    1
        //   /
        //  2
        // /
        //3
        TreeNode test2 = new TreeNode(1);
        test2.left = new TreeNode(2);
        test2.left.left = new TreeNode(3);
        
        // 测试用例3: 右偏树
        //  1
        //   \
        //    2
        //     \
        //      3
        TreeNode test3 = new TreeNode(1);
        test3.right = new TreeNode(2);
        test3.right.right = new TreeNode(3);
        
        // 测试用例4: 单节点树
        TreeNode test4 = new TreeNode(1);
        
        // 测试用例5: 之字形树
        //      1
        //     /
        //    2
        //     \
        //      3
        //     /
        //    4
        TreeNode test5 = new TreeNode(1);
        test5.left = new TreeNode(2);
        test5.left.right = new TreeNode(3);
        test5.left.right.left = new TreeNode(4);
        
        // 测试用例6: 满二叉树
        //       1
        //     /   \
        //    2     3
        //   / \   / \
        //  4   5 6   7
        TreeNode test6 = test1;  // 复用test1的树结构
        
        // 测试用例7: 不平衡树
        //        1
        //       /
        //      2
        //     /
        //    3
        //   /
        //  4
        // /
        //5
        TreeNode test7 = new TreeNode(1);
        test7.left = new TreeNode(2);
        test7.left.left = new TreeNode(3);
        test7.left.left.left = new TreeNode(4);
        test7.left.left.left.left = new TreeNode(5);
        
        // 测试用例8: 复杂不对称树
        //       1
        //     /   \
        //    2     3
        //   /     / \
        //  4     5   6
        //   \   /
        //    7 8
        TreeNode test8 = new TreeNode(1);
        test8.left = new TreeNode(2);
        test8.right = new TreeNode(3);
        test8.left.left = new TreeNode(4);
        test8.left.left.right = new TreeNode(7);
        test8.right.left = new TreeNode(5);
        test8.right.right = new TreeNode(6);
        test8.right.left.left = new TreeNode(8);
        
        // 测试用例9: 空树
        TreeNode test9 = null;
        
        // 测试用例10: 最大值测试
        //    100
        //   /   \
        //  99   98
        TreeNode test10 = new TreeNode(100);
        test10.left = new TreeNode(99);
        test10.right = new TreeNode(98);

        // 运行所有测试用例
        runTest("完全二叉树", test1, new int[]{1, 2, 4, 5, 3, 6, 7});
        runTest("左偏树", test2, new int[]{1, 2, 3});
        runTest("右偏树", test3, new int[]{1, 2, 3});
        runTest("单节点树", test4, new int[]{1});
        runTest("之字形树", test5, new int[]{1, 2, 3, 4});
        runTest("满二叉树", test6, new int[]{1, 2, 4, 5, 3, 6, 7});
        runTest("不平衡树", test7, new int[]{1, 2, 3, 4, 5});
        runTest("复杂不对称树", test8, new int[]{1, 2, 4, 7, 3, 5, 8, 6});
        runTest("空树", test9, new int[]{});
        runTest("最大值测试", test10, new int[]{100, 99, 98});
    }
}