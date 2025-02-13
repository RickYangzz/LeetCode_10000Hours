from typing import List

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def solve(self , preOrder: List[int], inOrder: List[int]) -> List[int]:
        root = self.buildTree(preOrder, inOrder)
        return self.getRightView(root)

    def buildTree(self, preOrder: List[int], inOrder: List[int]) -> TreeNode:
        if not preOrder or not inOrder: return None

        rootVal = preOrder[0]
        root = TreeNode(rootVal)
        for i in range(len(inOrder)):
            if inOrder[i] == rootVal:
                root.left = self.buildTree(preOrder[1:i+1], inOrder[0:i])
                root.right = self.buildTree(preOrder[i+1:len(preOrder)], inOrder[i+1:len(inOrder)])
                break
        return root
    
    def getRightView(self, root: TreeNode) -> List[int]:
        if not root: return []

        result = []
        queue= []
        queue.append(root)

        while queue:
            size = len(queue)
            while size > 0:
                top = queue.pop(0)
                size -= 1
                if top.left: queue.append(top.left)
                if top.right: queue.append(top.right)
                if size == 0: result.append(top.val)
        
        return result

