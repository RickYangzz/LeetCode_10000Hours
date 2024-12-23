from typing import List
from BM23_二叉树的前序遍历.python_solutions.tree_node import TreeNode

#
# 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
#
# 
# @param root TreeNode类 
# @return int整型一维数组
#
class RecursiveSolution:
    result = []

    def preorderTraversal(self , root: TreeNode) -> List[int]:
        if root == None:
            return self.result
        
        self.result.append(root.val)
        self.preorderTraversal(root.left)
        self.preorderTraversal(root.right)

        return self.result
