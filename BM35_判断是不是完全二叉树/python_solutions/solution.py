class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

#
# 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
#
# 
# @param root TreeNode类 
# @return bool布尔型
#
class Solution:
    def isCompleteTree(self , root: TreeNode) -> bool:
        queue = []
        isFinished = False

        queue.append(root)

        while queue:
            head = queue.pop(0)

            if not head:
                isFinished = True
                continue

            if isFinished:
                return False
            
            queue.append(head.left)
            queue.append(head.right)
        
        return True