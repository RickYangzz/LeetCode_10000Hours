import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class Solution {
    private HashMap<String, String> keyboard;
    private List<String> result;

    Solution(){
        keyboard = new HashMap<String, String>();
        keyboard.put("2", "abc");
        keyboard.put("3", "def");
        keyboard.put("4", "ghi");
        keyboard.put("5", "jkl");
        keyboard.put("6", "mno");
        keyboard.put("7", "pqrs");
        keyboard.put("8", "tuv");
        keyboard.put("9", "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return Collections.emptyList();

        result = new ArrayList<>();
        backtrack("", digits);
        return result;
    }

    private void backtrack(String combination, String digits){
        if(digits.length() == 0) {
            result.add(combination);
            return;
        }

        String letters = keyboard.get(String.valueOf(digits.charAt(0)));
        for (char letter : letters.toCharArray()) {
           backtrack(combination+letter, digits.substring(1)); 
        }
    }
}