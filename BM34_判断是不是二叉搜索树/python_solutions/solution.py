class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
import sys

# 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
#
# 
# @param root TreeNode类 
# @return bool布尔型
#
class Solution:
    pre = -sys.maxsize - 1

    def isValidBST(self , root: TreeNode) -> bool:
        if not root: return True

        if not self.isValidBST(root.left): return False
        if root.val < self.pre: return False

        self.pre = root.val

        return self.isValidBST(root.right)
