class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

#
# 
# @param pRootOfTree TreeNode类 
# @return TreeNode类
#
class Solution:
    def Convert(self, pRootOfTree ):
        if not pRootOfTree: return pRootOfTree

        head = None
        pre = None
        stack = []

        while pRootOfTree or stack:
            while pRootOfTree:
                stack.append(pRootOfTree)
                pRootOfTree = pRootOfTree.left
            
            top = stack.pop()

            if not head and not pre:
                head = top
                pre = top
            else:
                pre.right = top
                top.left = pre
                pre = top
            
            pRootOfTree = top.right
        
        return head

