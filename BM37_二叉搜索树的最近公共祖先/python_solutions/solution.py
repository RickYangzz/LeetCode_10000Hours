from typing import List

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def lowestCommonAncestor(self , root: TreeNode, p: int, q: int) -> int:
        first = self.getTargetPath(root, p)
        second = self.getTargetPath(root, q)

        i = 0
        while (i < len(first) and i < len(second)):
            if(first[i] == second[i]):
                i += 1
            else:
                break
        
        return first[i-1]
        
    
    def getTargetPath(self, root: TreeNode, target: int) -> List[int]:
        result = []

        while root.val != target:
            result.append(root.val)
            if target > root.val:
                root = root.right
            else:
                root = root.left
        
        result.append(root.val)

        return result
        