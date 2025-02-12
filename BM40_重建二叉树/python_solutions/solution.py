from typing import List

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def reConstructBinaryTree(self , preOrder: List[int], vinOrder: List[int]) -> TreeNode:
        if not preOrder or not vinOrder: return None

        rootVal = preOrder[0]
        root = TreeNode(rootVal)

        for i in range(len(vinOrder)):
            if vinOrder[i] == rootVal:
                root.left = self.reConstructBinaryTree(
                    preOrder[1:i+1],
                    vinOrder[0:i]
                )
                root.right = self.reConstructBinaryTree(
                    preOrder[i+1:len(preOrder)],
                    vinOrder[i+1:len(vinOrder)]
                )
                break
        
        return root
        

