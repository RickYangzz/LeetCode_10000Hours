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
    def __init__(self):
        self.store = {}

    def IsBalanced_Solution(self , pRoot: TreeNode) -> bool:
        self.calculate(pRoot)
        return self.judge(pRoot)
    
    def calculate(self, root: TreeNode) -> int:
        if not root: return 0

        leftHeight = self.calculate(root.left)
        rightHeight = self.calculate(root.right)

        rootHeight = max(leftHeight, rightHeight) + 1

        self.store[root] = rootHeight
        return rootHeight
    
    def judge(self, root: TreeNode) -> bool:
        if not root: return True

        leftHeight =  self.store[root.left] if root.left else 0
        rightHeight = self.store[root.right] if root.right else 0

        result = abs(leftHeight - rightHeight) <= 1

        return result and self.judge(root.left) and self.judge(root.right)
