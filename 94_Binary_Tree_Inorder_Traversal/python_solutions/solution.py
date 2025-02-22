# Definition for a binary tree node.
from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def __init__(self):
        self.result = []
    
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        if not root: return []

        self.inorderTraversal(root.left)
        self.result.append(root.val)
        self.inorderTraversal(root.right)

        return self.result