from typing import List, Optional


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


# 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
#
# @param root TreeNode类
# @return int整型一维数组
#
class Solution:
    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        result: List[int] = []
        stack: List[TreeNode] = []
        pre: Optional[TreeNode] = None

        while root or len(stack):
            while root:
                stack.append(root)
                root = root.left

            node = stack.pop()
            if node.right == None or node.right == pre:
                result.append(node.val)
                pre = node
            else:
                stack.append(node)
                root = node.right

        return result
