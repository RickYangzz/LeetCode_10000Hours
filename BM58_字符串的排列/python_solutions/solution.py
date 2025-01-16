from typing import List


class Solution:
    def Permutation(self, str: str) -> List[str]:
        strArr = sorted(list(str))  # 将字符串转换为列表并排序，方便后续的去重
        used = [False] * len(strArr)  # 初始化布尔列表，用于标记字符是否已被使用
        result = []  # 存储所有的排列结果
        strBuilder = []  # 用于构建当前排列的字符串

        # 开始递归构建所有排列
        self.recursion(result, strArr, strBuilder, used)

        return result

    def recursion(
        self,
        result: List[str],
        strArr: List[str],
        strBuilder: List[str],
        used: List[bool],
    ) -> None:
        # 递归终止条件：当当前排列的长度等于原字符串的长度时，说明排列完成
        if len(strBuilder) == len(strArr):
            result.append("".join(strBuilder))  # 将当前排列加入结果列表
            return

        # 遍历字符串的每个字符
        for i in range(len(strArr)):
            # 如果当前字符已经被使用过，则跳过
            if used[i]:
                continue

            # 如果当前字符和前一个字符相同，并且前一个字符没有被使用过，跳过当前字符
            # 这样可以避免在递归过程中出现重复的排列
            if i > 0 and strArr[i] == strArr[i - 1] and not used[i - 1]:
                continue

            used[i] = True  # 标记当前字符已被使用
            strBuilder.append(strArr[i])  # 将当前字符加入排列中

            # 递归调用，继续构建下一个字符
            self.recursion(result, strArr, strBuilder, used)

            # 回溯操作：撤销当前选择
            used[i] = False  # 标记当前字符未被使用
            strBuilder.pop()  # 移除排列中的最后一个字符
