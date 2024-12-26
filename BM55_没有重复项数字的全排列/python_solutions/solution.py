#
# 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
#
# 
# @param num int整型一维数组 
# @return int整型二维数组
#
from typing import List


class Solution:
    def permute(self , num: List[int]) -> List[List[int]]:
        result: List[List[int]] = []
        self.recursion(result, num, 0)
        return result

    def recursion(self, container: List[List[int]], numbers: List[int], index: int):
        if index == len(numbers)-1:
            container.append(numbers[:])
        else:
            for i in range(index, len(numbers)):
                self.move(numbers, i, index)
                self.recursion(container, numbers, index+1);
                self.move(numbers, index, i)
    
    def move(self, numbers: List[int], from_index: int, to_index: int):
        target_number = numbers.pop(from_index)
        numbers.insert(to_index, target_number)