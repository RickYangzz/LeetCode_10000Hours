package BM58_字符串的排列.java_solutions;

import java.util.*;

public class Solution {
    /**
     * 输入一个长度为 n 的字符串，打印出该字符串中字符的所有排列。
     * 允许返回任意顺序的排列结果。
     * 
     * 例如输入字符串 "abc"，输出所有排列为 {"abc", "acb", "bac", "bca", "cab", "cba"}。
     *
     * @param str 输入的字符串
     * @return 返回所有排列的字符串列表
     */
    public ArrayList<String> Permutation(String str) {
        // 如果字符串为空或为null，直接返回空的结果
        if (str == "" || str == null)
            return new ArrayList<>();

        // 将字符串转换为字符数组，便于后续操作
        char[] strArr = str.toCharArray();
        
        // 对字符数组进行排序，保证相同字符排列时能避免重复
        Arrays.sort(strArr);

        // 用于记录每个字符是否已经被使用过
        Boolean[] used = new Boolean[str.length()];
        Arrays.fill(used, false);  // 初始化为 false，表示所有字符都未被使用

        // 用于存储排列结果的 List
        ArrayList<String> result = new ArrayList<>();
        
        // 开始回溯算法，传入字符数组、当前构建的排列、使用标志数组和结果集合
        Permutation(strArr, new StringBuilder(), used, result);
        
        return result;  // 返回所有排列的结果
    }

    /**
     * 回溯方法，生成所有的排列
     * 
     * @param strArr 输入的字符数组（已经排序）
     * @param strBuilder 当前构建的排列（使用 StringBuilder 来高效地拼接字符串）
     * @param used 记录每个字符是否已经使用过
     * @param result 存储所有排列结果的列表
     */
    private void Permutation(char[] strArr, StringBuilder strBuilder, Boolean[] used, ArrayList<String> result) {
        // 如果当前排列长度等于字符串长度，说明已经构造了一个完整的排列
        if (strBuilder.length() == strArr.length) {
            result.add(strBuilder.toString());  // 将当前排列添加到结果列表中
            return;
        }

        // 遍历字符数组中的每个字符，进行回溯
        for (int i = 0; i < strArr.length; i++) {
            // 如果该字符已经被使用，跳过
            if (used[i])
                continue;
            
            /**
             * 这里是核心的去重逻辑。
             * used[i - 1] 标记了前一个字符是否已经被使用过。
             * 如果 used[i - 1] 为 false，意味着前一个字符没有被使用过，
             * 那么如果我们此时选择当前字符 strArr[i]，就会产生一个与前一次选择相同的排列。
             * 因为在回溯过程中，前一个字符没有被使用过，说明前一个字符在当前位置上已经被尝试过了。
             */
            // 如果当前字符和前一个字符相同，但前一个字符没有被使用过，跳过（避免重复排列）
            if (i > 0 && strArr[i] == strArr[i - 1] && !used[i - 1])
                continue;

            // 标记当前字符已被使用
            used[i] = true;
            
            // 将当前字符添加到当前排列中
            strBuilder.append(strArr[i]);

            // 递归调用，继续构造排列
            Permutation(strArr, strBuilder, used, result);

            // 回溯：撤销选择，标记当前字符为未使用
            used[i] = false;
            
            // 移除当前字符，继续尝试其他字符
            strBuilder.deleteCharAt(strBuilder.length() - 1);
        }
    }
}
