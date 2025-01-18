package BM101_设计LFU缓存结构.java_solutions;

import java.util.Arrays;

public class SolutionTest {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic Operations
        System.out.println("Test Case 1: Basic Operations");
        int[][] operators1 = {
            {1, 1, 1},  // set(1, 1)
            {1, 2, 2},  // set(2, 2)
            {2, 1},     // get(1) → 1
            {2, 2},     // get(2) → 2
        };
        int k1 = 2;
        int[] result1 = solution.LFU(operators1, k1);
        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.equals(result1, new int[]{1, 2}) ? "passed" : "failed");
        System.out.println();

        // Test Case 2: Cache Capacity Exceeded
        System.out.println("Test Case 2: Cache Capacity Exceeded");
        int[][] operators2 = {
            {1, 1, 1},  // set(1, 1)
            {1, 2, 2},  // set(2, 2)
            {1, 3, 3},  // set(3, 3) → Cache is full, remove least used (1)
            {2, 1},     // get(1) → -1 (removed)
            {2, 2},     // get(2) → 2
            {2, 3},     // get(3) → 3
        };
        int k2 = 2;
        int[] result2 = solution.LFU(operators2, k2);
        System.out.println(Arrays.toString(result2));
        System.out.println(Arrays.equals(result2, new int[]{-1, 2, 3}) ? "passed" : "failed");
        System.out.println();

        // Test Case 3: Multiple `get` and `set` Operations with Same Key
        System.out.println("Test Case 3: Multiple `get` and `set` Operations with Same Key");
        int[][] operators3 = {
            {1, 1, 1},  // set(1, 1)
            {1, 2, 2},  // set(2, 2)
            {2, 1},     // get(1) → 1
            {1, 1, 10}, // set(1, 10)
            {2, 1},     // get(1) → 10
        };
        int k3 = 2;
        int[] result3 = solution.LFU(operators3, k3);
        System.out.println(Arrays.toString(result3));
        System.out.println(Arrays.equals(result3, new int[]{1, 10}) ? "passed" : "failed");
        System.out.println();

        // Test Case 4: Single Entry Cache
        System.out.println("Test Case 4: Single Entry Cache");
        int[][] operators4 = {
            {1, 1, 1},  // set(1, 1)
            {2, 1},     // get(1) → 1
            {1, 2, 2},  // set(2, 2) → Cache is full, remove 1
            {2, 1},     // get(1) → -1 (removed)
            {2, 2},     // get(2) → 2
        };
        int k4 = 1;
        int[] result4 = solution.LFU(operators4, k4);
        System.out.println(Arrays.toString(result4));
        System.out.println(Arrays.equals(result4, new int[]{1, -1, 2}) ? "passed" : "failed");
        System.out.println();

        // Test Case 5: Handling Multiple LFU Keys
        System.out.println("Test Case 5: Handling Multiple LFU Keys");
        int[][] operators5 = {
            {1, 1, 1},  // set(1, 1)
            {1, 2, 2},  // set(2, 2)
            {1, 3, 3},  // set(3, 3)
            {2, 1},     // get(1) → 1
            {2, 2},     // get(2) → 2
            {1, 4, 4},  // set(4, 4) → Cache is full, remove 3 (LFU)
            {2, 3},     // get(3) → -1 (removed)
            {2, 4},     // get(4) → 4
        };
        int k5 = 3;
        int[] result5 = solution.LFU(operators5, k5);
        System.out.println(Arrays.toString(result5));
        System.out.println(Arrays.equals(result5, new int[]{1, 2, -1, 4}) ? "passed" : "failed");
        System.out.println();

        // Test Case 6: Empty Cache
        System.out.println("Test Case 6: Empty Cache");
        int[][] operators6 = {};
        int k6 = 2;
        int[] result6 = solution.LFU(operators6, k6);
        System.out.println(Arrays.toString(result6));
        System.out.println(Arrays.equals(result6, new int[]{}) ? "passed" : "failed");
        System.out.println();

        // Test Case 7: Repeated `get` Without `set`
        System.out.println("Test Case 7: Repeated `get` Without `set`");
        int[][] operators7 = {
            {1, 1, 1},  // set(1, 1)
            {2, 2},     // get(2) → -1 (not in cache)
            {2, 1},     // get(1) → 1
            {2, 3},     // get(3) → -1 (not in cache)
        };
        int k7 = 2;
        int[] result7 = solution.LFU(operators7, k7);
        System.out.println(Arrays.toString(result7));
        System.out.println(Arrays.equals(result7, new int[]{-1, 1, -1}) ? "passed" : "failed");
        System.out.println();

        // Test Case 8: Test Cache with Larger `k`
        System.out.println("Test Case 8: Test Cache with Larger `k`");
        int[][] operators8 = {
            {1, 1, 1},  // set(1, 1)
            {1, 2, 2},  // set(2, 2)
            {1, 3, 3},  // set(3, 3)
            {1, 4, 4},  // set(4, 4)
            {2, 1},     // get(1) → 1
            {2, 2},     // get(2) → 2
            {2, 3},     // get(3) → 3
            {2, 4},     // get(4) → 4
        };
        int k8 = 5;
        int[] result8 = solution.LFU(operators8, k8);
        System.out.println(Arrays.toString(result8));
        System.out.println(Arrays.equals(result8, new int[]{1, 2, 3, 4}) ? "passed" : "failed");
        System.out.println();
    }
}
