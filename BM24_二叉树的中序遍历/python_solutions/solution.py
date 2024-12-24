from typing import List, Optional


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


# 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
#
# 
# @param root TreeNode类 
# @return int整型一维数组
#
class Solution:
    def inorderTraversal(self , root:  Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        
        result = []
        stack = []

        while root or len(stack):
            while root:
                stack.append(root)
                root = root.left

            topNode = stack.pop()
            result.append(topNode.val)
            root = topNode.right

        return result