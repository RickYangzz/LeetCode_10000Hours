from typing import List
from tree_node import TreeNode

#
# 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
# 
# 数据范围：二叉树的节点数量满足 1≤n≤100，二叉树节点的值满足 1≤val≤100，树的各节点的值各不相同
#
# @param root TreeNode类 
# @return int整型一维数组
#
class StackSolution:
    
    def preorderTraversal(self , root: TreeNode) -> List[int]:
        if root == None: 
            return []
        
        result = []
        stack = []
        stack.append(root)

        while len(stack):
            topNode = stack.pop()
            if topNode == None:
                continue

            result.append(topNode.val)
            stack.append(topNode.right)
            stack.append(topNode.left)

        return result

