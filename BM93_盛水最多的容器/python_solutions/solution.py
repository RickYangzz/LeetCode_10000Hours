#
# 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
#
# 
# @param height int整型一维数组 
# @return int整型
#
class Solution:
    def maxArea(self , height: List[int]) -> int:
        if len(height) < 2: return 0

        left = 0 
        right = len(height) -1
        max_capacity = 0

        while left < right:
            capacity = (right -left) * min(height[left], height[right])
            max_capacity = max(capacity, max_capacity)

            if(height[left] < height[right]):
                left += 1
            else : 
                right -= 1

        return max_capacity