package BM97_旋转数组.java_solutions;

import java.util.Arrays;

public class SolutionTest {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Basic case, rotate an array by 2
        int[] array1 = {1, 2, 3, 4, 5};
        int[] result1 = solution.solve(5, 2, array1);
        System.out.println("Test case 1 result: " + Arrays.toString(result1)); // Expected: [4, 5, 1, 2, 3]

        // Test case 2: Rotate by 0, no change expected
        int[] array2 = {1, 2, 3, 4, 5};
        int[] result2 = solution.solve(5, 0, array2);
        System.out.println("Test case 2 result: " + Arrays.toString(result2)); // Expected: [1, 2, 3, 4, 5]

        // Test case 3: Rotate by full length, array should remain the same
        int[] array3 = {1, 2, 3, 4, 5};
        int[] result3 = solution.solve(5, 5, array3);
        System.out.println("Test case 3 result: " + Arrays.toString(result3)); // Expected: [1, 2, 3, 4, 5]

        // Test case 4: Rotate by more than length (m > n), should behave like m % n
        int[] array4 = {1, 2, 3, 4, 5};
        int[] result4 = solution.solve(5, 7, array4);
        System.out.println("Test case 4 result: " + Arrays.toString(result4)); // Expected: [4, 5, 1, 2, 3]

        // Test case 5: Array with one element, no rotation needed
        int[] array5 = {99};
        int[] result5 = solution.solve(1, 3, array5);
        System.out.println("Test case 5 result: " + Arrays.toString(result5)); // Expected: [99]

        // Test case 6: Empty array, no change
        int[] array6 = {};
        int[] result6 = solution.solve(0, 3, array6);
        System.out.println("Test case 6 result: " + Arrays.toString(result6)); // Expected: []

        // Test case 7: Array with large number of elements (stress test)
        int[] array7 = new int[1000000];
        for (int i = 0; i < array7.length; i++) {
            array7[i] = i + 1;
        }
        long startTime = System.nanoTime();
        int[] result7 = solution.solve(1000000, 1000000, array7);
        long endTime = System.nanoTime();
        System.out.println("Test case 7 result: " + (endTime - startTime) + " nanoseconds");
    }
}
