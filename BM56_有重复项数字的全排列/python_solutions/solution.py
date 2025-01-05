from typing import List

class Solution:
    def permuteUnique(self, num: List[int]) -> List[List[int]]:
        # 先排序以便于去重处理
        num.sort()
        result: List[List[int]] = []
        temp: List[int] = []
        used: List[bool] = [False] * len(num)  # 使用布尔数组记录数字是否被使用
        self.backtrack(result, num, temp, used)
        return result

    def backtrack(self, result: List[List[int]], num: List[int], temp: List[int], used: List[bool]):
        # 如果临时排列的长度等于输入数组长度，添加到结果中
        if len(temp) == len(num):
            result.append(temp[:])  # 深拷贝 temp，避免后续修改影响结果
            return

        for i in range(len(num)):
            # 跳过已经使用过的数字
            if used[i]:
                continue
            # 跳过重复数字：当前数字和前一个相同，且前一个未被使用
            if i > 0 and num[i] == num[i-1] and not used[i-1]:
                continue

            # 做选择
            used[i] = True
            temp.append(num[i])

            # 递归进入下一层
            self.backtrack(result, num, temp, used)

            # 撤销选择
            used[i] = False
            temp.pop()
