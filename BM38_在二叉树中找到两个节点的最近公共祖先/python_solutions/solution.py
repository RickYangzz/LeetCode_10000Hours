from typing import List

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def __init__(self):
        self.flag = False
    
    def lowestCommonAncestor(self , root: TreeNode, o1: int, o2: int) -> int:
        path_a = []
        path_b = []

        self.dfs(root, o1, path_a)
        self.flag = False
        self.dfs(root, o2, path_b)

        res = 0
        for i in range(min( len(path_a), len(path_b) )):
            a = path_a[i]
            b = path_b[i]
            if a == b:
                res = a
            else:
                break
        return res
    
    def dfs(self, root: TreeNode, target: int, path: List[int]) -> int:
        if self.flag or not root: return

        path.append(root.val)

        if root.val == target:
            self.flag = True
            return
        
        self.dfs(root.left, target, path)
        self.dfs(root.right, target, path)

        if self.flag: return

        path.pop()
