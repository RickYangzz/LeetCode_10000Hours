class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

#
# 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
#
# 
# @param pRoot TreeNode类 
# @return bool布尔型
#
class Solution:
    def IsBalanced_Solution(self , pRoot: TreeNode) -> bool:
        return self.calculate(pRoot) != -1
    
    def calculate(self, root: TreeNode) -> int:
        if not root: return 0

        leftHeight = self.calculate(root.left)
        if leftHeight == -1: return -1
        rightHeight = self.calculate(root.right)
        if rightHeight == -1: return -1

        if abs(leftHeight - rightHeight) > 1:
            return -1
        
        return max(leftHeight, rightHeight) + 1
            
