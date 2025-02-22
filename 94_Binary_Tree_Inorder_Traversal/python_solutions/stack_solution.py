# Definition for a binary tree node.
from typing import List, Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        if not root: return []

        result = []
        stack = []

        while root or stack:
            while root:
                stack.append(root)
                root = root.left
            
            top = stack.pop()
            result.append(top.val)
            root = top.right

        return result