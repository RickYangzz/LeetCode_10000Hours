package BM1_二分查找_I.java_solutions;

/**
 * 二分查找算法的测试类
 * 比较迭代实现(IterativeSolution)和递归实现(RecursiveSolution)的结果
 */
public class SolutionTest {
    /**
     * 运行单个测试用例，并比较两种实现的结果
     * 
     * @param nums 输入数组
     * @param target 目标值
     * @param expected 期望结果
     */
    public static void runTest(int[] nums, int target, int expected) {
        IterativeSolution iterativeSolution = new IterativeSolution();
        RecursiveSolution recursiveSolution = new RecursiveSolution();
        
        int iterativeResult = iterativeSolution.search(nums, target);
        int recursiveResult = recursiveSolution.search(nums, target);
        
        // 打印测试结果
        System.out.printf("Input array: %s\n", java.util.Arrays.toString(nums));
        System.out.printf("Target: %d\n", target);
        System.out.printf("Expected: %d\n", expected);
        System.out.printf("Iterative Result: %d (%s)\n", iterativeResult, iterativeResult == expected ? "PASSED" : "FAILED");
        System.out.printf("Recursive Result: %d (%s)\n\n", recursiveResult, recursiveResult == expected ? "PASSED" : "FAILED");
    }

    public static void main(String[] args) {
        // 测试用例1：目标值在数组中间
        runTest(new int[]{1, 2, 4, 4, 5}, 4, 2);

        // 测试用例2：目标值不存在
        runTest(new int[]{1, 2, 4, 4, 5}, 3, -1);

        // 测试用例3：空数组
        runTest(new int[]{}, 5, -1);

        // 测试用例4：单元素数组，找到
        runTest(new int[]{1}, 1, 0);

        // 测试用例5：单元素数组，未找到
        runTest(new int[]{1}, 2, -1);
        
        // 测试用例6：目标值在数组开头
        runTest(new int[]{1, 3, 5, 7, 9}, 1, 0);
        
        // 测试用例7：目标值在数组末尾
        runTest(new int[]{1, 3, 5, 7, 9}, 9, 4);
        
        // 测试用例8：较大的有序数组
        runTest(new int[]{1, 3, 5, 7, 9, 11, 13, 15, 17, 19}, 13, 6);
    }
} 