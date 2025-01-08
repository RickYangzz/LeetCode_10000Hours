package BM84_最长公共前缀.java_solutions;

public class SolutionTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1: Common prefix exists
        String[] test1 = {"flower", "flow", "flight"};
        String result1 = solution.longestCommonPrefix(test1);
        assert result1.equals("fl");
        
        // Test case 2: No common prefix
        String[] test2 = {"dog", "racecar", "car"}; 
        String result2 = solution.longestCommonPrefix(test2);
        assert result2.equals("");
        
        // Test case 3: Single string
        String[] test3 = {"hello"};
        String result3 = solution.longestCommonPrefix(test3);
        assert result3.equals("hello");
        
        // Test case 4: Empty array
        String[] test4 = {};
        String result4 = solution.longestCommonPrefix(test4);
        assert result4.equals("");
        
        // Test case 5: Array with empty string
        String[] test5 = {"", "b"};
        String result5 = solution.longestCommonPrefix(test5);
        assert result5.equals("");
        
        // Test case 6: All identical strings
        String[] test6 = {"abc", "abc", "abc"};
        String result6 = solution.longestCommonPrefix(test6);
        assert result6.equals("abc");

        System.out.println("All test cases passed!");
    }
}