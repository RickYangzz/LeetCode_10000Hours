class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

# 
# @param pRootOfTree TreeNode类 
# @return TreeNode类
#
class Solution:

    def __init__(self):
        self.head = None
        self.pre = None
    
    def Convert(self, pRootOfTree):
        if not pRootOfTree: return pRootOfTree

        self.Convert(pRootOfTree.left)
        
        if not self.head:
            self.head = pRootOfTree
            self.pre = pRootOfTree
        else:
            self.pre.right = pRootOfTree
            pRootOfTree.left = self.pre
            self.pre = pRootOfTree

        self.Convert(pRootOfTree.right)
        
        return self.head

