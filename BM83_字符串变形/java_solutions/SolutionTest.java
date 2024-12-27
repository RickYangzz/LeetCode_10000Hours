package BM83_字符串变形.java_solutions;

public class SolutionTest {

    public static void main(String[] args) {
        testTrans_NormalCase();
        testTrans_AllUpperCase();
        testTrans_AllLowerCase();
        testTrans_MixedCaseWithSpaces();
        testTrans_EmptyString();
        testTrans_SingleWord();
        System.out.println("All tests completed.");
    }

    public static void testTrans_NormalCase() {
        Solution solution = new Solution();
        String input = "Hello World";
        int n = input.length();
        String expected = "wORLD hELLO";
        String result = solution.trans(input, n);
        System.out.println("Test: testTrans_NormalCase");
        System.out.println("Input: " + input);
        System.out.println("Expected: " + expected);
        System.out.println("Result: " + result);
        if (!expected.equals(result)) {
            System.out.println("Result: FAILED");
            System.out.println("--------------------------------");
            throw new AssertionError("Test failed: testTrans_NormalCase. Expected: " + expected + ", but got: " + result);
        }
        System.out.println("Result: PASSED");
        System.out.println("--------------------------------");
    }

    public static void testTrans_AllUpperCase() {
        Solution solution = new Solution();
        String input = "HELLO";
        int n = input.length();
        String expected = "hello";
        String result = solution.trans(input, n);
        System.out.println("Test: testTrans_AllUpperCase");
        System.out.println("Input: " + input);
        System.out.println("Expected: " + expected);
        System.out.println("Result: " + result);
        if (!expected.equals(result)) {
            System.out.println("Result: FAILED");
            System.out.println("--------------------------------");
            throw new AssertionError("Test failed: testTrans_AllUpperCase. Expected: " + expected + ", but got: " + result);
        }
        System.out.println("Result: PASSED");
        System.out.println("--------------------------------");
    }

    public static void testTrans_AllLowerCase() {
        Solution solution = new Solution();
        String input = "hello";
        int n = input.length();
        String expected = "HELLO";
        String result = solution.trans(input, n);
        System.out.println("Test: testTrans_AllLowerCase");
        System.out.println("Input: " + input);
        System.out.println("Expected: " + expected);
        System.out.println("Result: " + result);
        if (!expected.equals(result)) {
            System.out.println("Result: FAILED");
            System.out.println("--------------------------------");
            throw new AssertionError("Test failed: testTrans_AllLowerCase. Expected: " + expected + ", but got: " + result);
        }
        System.out.println("Result: PASSED");
        System.out.println("--------------------------------");
    }

    public static void testTrans_MixedCaseWithSpaces() {
        Solution solution = new Solution();
        String input = "Java is Fun";
        int n = input.length();
        String expected = "fUN IS jAVA";
        String result = solution.trans(input, n);
        System.out.println("Test: testTrans_MixedCaseWithSpaces");
        System.out.println("Input: " + input);
        System.out.println("Expected: " + expected);
        System.out.println("Result: " + result);
        if (!expected.equals(result)) {
            System.out.println("Result: FAILED");
            System.out.println("--------------------------------");
            throw new AssertionError("Test failed: testTrans_MixedCaseWithSpaces. Expected: " + expected + ", but got: " + result);
        }
        System.out.println("Result: PASSED");
        System.out.println("--------------------------------");
    }

    public static void testTrans_EmptyString() {
        Solution solution = new Solution();
        String input = "";
        int n = input.length();
        String expected = "";
        String result = solution.trans(input, n);
        System.out.println("Test: testTrans_EmptyString");
        System.out.println("Input: " + input);
        System.out.println("Expected: " + expected);
        System.out.println("Result: " + result);
        if (!expected.equals(result)) {
            System.out.println("Result: FAILED");
            System.out.println("--------------------------------");
            throw new AssertionError("Test failed: testTrans_EmptyString. Expected: " + expected + ", but got: " + result);
        }
        System.out.println("Result: PASSED");
        System.out.println("--------------------------------");
    }

    public static void testTrans_SingleWord() {
        Solution solution = new Solution();
        String input = "Test";
        int n = input.length();
        String expected = "tEST";
        String result = solution.trans(input, n);
        System.out.println("Test: testTrans_SingleWord");
        System.out.println("Input: " + input);
        System.out.println("Expected: " + expected);
        System.out.println("Result: " + result);
        if (!expected.equals(result)) {
            System.out.println("Result: FAILED");
            System.out.println("--------------------------------");
            throw new AssertionError("Test failed: testTrans_SingleWord. Expected: " + expected + ", but got: " + result);
        }
        System.out.println("Result: PASSED");
        System.out.println("--------------------------------");
    }
}
