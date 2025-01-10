package BM53_缺失的第一个正整数.java_solutions;

public class SolutionTest {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Simple array with missing 2
        test(solution, new int[] { 1, 3, 4, 5 }, 2);

        // Test Case 2: Array with negative numbers
        test(solution, new int[] { 3, 4, -1, 1 }, 2);

        // Test Case 3: Array with all positive sequential numbers
        test(solution, new int[] { 1, 2, 3, 4 }, 5);

        // Test Case 4: Array with single element
        test(solution, new int[] { 1 }, 2);

        // Test Case 5: Empty array
        test(solution, new int[] {}, 1);

        // Test Case 6: Array with all negative numbers
        test(solution, new int[] { -1, -2, -3 }, 1);

        // Test Case 7: Array with zeros
        test(solution, new int[] { 0, 1, 2 }, 3);

        // Test Case 8: Array with large numbers
        test(solution, new int[] { 7, 8, 9, 11, 12 }, 1);

        // Test Case 9: Array with 1 missing
        test(solution, new int[] { 2, 3, 4, 5 }, 1);
    }

    private static void test(Solution solution, int[] input, int expected) {
        int result = solution.minNumberDisappeared(input);
        System.out.printf(
            "Input: %s\nExpected: %d\nActual: %d\n%s\n\n",
            arrayToString(input),
            expected,
            result,
            result == expected ? "PASSED" : "FAILED"
        );
    }

    private static String arrayToString(int[] arr) {
        if (arr.length == 0)
            return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length - 1; i++) {
            sb.append(arr[i]).append(", ");
        }
        sb.append(arr[arr.length - 1]).append("]");
        return sb.toString();
    }
}