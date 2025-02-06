package BM49_表达式求值.java_solutions;

public class SolutionTest {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Simple addition
        String expression1 = "2+3";
        System.out.println("Expression: " + expression1 + " | Result: " + solution.solve(expression1)); // Expected: 5

        // Test case 2: Addition and multiplication
        String expression2 = "2+3*4";
        System.out.println("Expression: " + expression2 + " | Result: " + solution.solve(expression2)); // Expected: 14

        // Test case 3: Parentheses with addition
        String expression3 = "(2+3)";
        System.out.println("Expression: " + expression3 + " | Result: " + solution.solve(expression3)); // Expected: 5

        // Test case 4: Nested parentheses
        String expression4 = "2*(3+(4*5))";
        System.out.println("Expression: " + expression4 + " | Result: " + solution.solve(expression4)); // Expected: 46

        // Test case 5: Complex expression
        String expression5 = "2*(3+4)*5";
        System.out.println("Expression: " + expression5 + " | Result: " + solution.solve(expression5)); // Expected: 70

        // Test case 6: Subtraction and parentheses
        String expression6 = "10-(2+3)";
        System.out.println("Expression: " + expression6 + " | Result: " + solution.solve(expression6)); // Expected: 5

        // Test case 7: Mixed operators
        String expression7 = "2+3*4-5";
        System.out.println("Expression: " + expression7 + " | Result: " + solution.solve(expression7)); // Expected: 9

        // Test case 8: Parentheses with subtraction
        String expression8 = "(10-2)*3";
        System.out.println("Expression: " + expression8 + " | Result: " + solution.solve(expression8)); // Expected: 24

        // Test case 9: Multiple nested parentheses
        String expression9 = "((2+3)*(4+5))";
        System.out.println("Expression: " + expression9 + " | Result: " + solution.solve(expression9)); // Expected: 45

        // Test case 10: Single number
        String expression10 = "42";
        System.out.println("Expression: " + expression10 + " | Result: " + solution.solve(expression10)); // Expected: 42
    }
}
