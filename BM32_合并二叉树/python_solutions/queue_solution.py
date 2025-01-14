class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

# 
# 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
#
# 
# @param t1 TreeNode类 
# @param t2 TreeNode类 
# @return TreeNode类
#
class Solution:
    def mergeTrees(self , t1: TreeNode, t2: TreeNode) -> TreeNode:
        if not t1 and not t2: return None
        if not t1: return t2
        if not t2: return t1

        queue = []
        queue1 = []
        queue2 = [] 

        head = TreeNode(t1.val+t2.val)
        queue.append(head)
        queue1.append(t1)
        queue2.append(t2)

        while queue and queue1 and queue2:
            total = queue.pop(0)
            node1 = queue1.pop(0)
            node2 = queue2.pop(0)

            if node1.left and node2.left:
                total.left = TreeNode(node1.left.val + node2.left.val)
                queue.append(total.left)
                queue1.append(node1.left)
                queue2.append(node2.left)
            elif node1.left:
                total.left = node1.left
            elif node2.left:
                total.left = node2.left
            
            if node1.right and node2.right:
                total.right = TreeNode(node1.right.val + node2.right.val)
                queue.append(total.right)
                queue1.append(node1.right)
                queue2.append(node2.right)
            elif node1.right:
                total.right = node1.right
            elif node2.right:
                total.right = node2.right

        return head