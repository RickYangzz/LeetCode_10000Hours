import unittest
from stack_solution import StackSolution
from tree_node import TreeNode
from typing import List

class TestPreorderTraversal(unittest.TestCase):
    def setUp(self):
        self.solution = StackSolution()

    def run_test_case(self, name: str, root: TreeNode, expected: List[int]):
        result = self.solution.preorderTraversal(root)
        print(f"\n预期结果: {expected}")
        print(f"实际结果: {result}")
        print(f"测试状态: {'通过' if result == expected else '失败'}")
        self.assertEqual(result, expected)

    def test_empty_tree(self):
        """测试空树"""
        self.run_test_case("空树", None, [])

    def test_single_node(self):
        """测试单节点树"""
        root = TreeNode(1)
        self.run_test_case("单节点树", root, [1])

    def test_complete_binary_tree(self):
        """测试完全二叉树"""
        root = TreeNode(1)
        root.left = TreeNode(2)
        root.right = TreeNode(3)
        root.left.left = TreeNode(4)
        root.left.right = TreeNode(5)
        root.right.left = TreeNode(6)
        root.right.right = TreeNode(7)
        self.run_test_case("完全二叉树", root, [1,2,4,5,3,6,7])

    def test_left_skewed_tree(self):
        """测试左偏树"""
        root = TreeNode(1)
        root.left = TreeNode(2)
        root.left.left = TreeNode(3)
        self.run_test_case("左偏树", root, [1,2,3])

    def test_right_skewed_tree(self):
        """测试右偏树"""
        root = TreeNode(1)
        root.right = TreeNode(2)
        root.right.right = TreeNode(3)
        self.run_test_case("右偏树", root, [1,2,3])

    def test_zigzag_tree(self):
        """测试之字形树"""
        root = TreeNode(1)
        root.left = TreeNode(2)
        root.left.right = TreeNode(3)
        root.left.right.left = TreeNode(4)
        self.run_test_case("之字形树", root, [1,2,3,4])

    def test_asymmetric_tree(self):
        """测试不对称树"""
        root = TreeNode(1)
        root.left = TreeNode(2)
        root.right = TreeNode(3)
        root.left.left = TreeNode(4)
        root.left.left.right = TreeNode(7)
        root.right.left = TreeNode(5)
        root.right.right = TreeNode(6)
        root.right.left.left = TreeNode(8)
        self.run_test_case("不对称树", root, [1,2,4,7,3,5,8,6])

if __name__ == '__main__':
    unittest.main(verbosity=2)