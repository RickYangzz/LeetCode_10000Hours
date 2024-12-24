from solution import TreeNode, Solution
# Helper function to build a tree from a list (level-order)
def build_tree(values):
    if not values:
        return None
    nodes = [TreeNode(x) if x is not None else None for x in values]
    kids = nodes[::-1]
    root = kids.pop()
    for node in nodes:
        if node:
            if kids:
                node.left = kids.pop()
            if kids:
                node.right = kids.pop()
    return root

# Test cases
def test_inorder_traversal():
    solution = Solution()
    
    # Test Case 1: Empty Tree
    root1 = None
    result1 = solution.inorderTraversal(root1)
    expected1 = []
    print("Test Case 1 - Empty Tree:", "Passed" if result1 == expected1 else f"Failed (Result: {result1})")

    # Test Case 2: Single Node
    root2 = TreeNode(1)
    result2 = solution.inorderTraversal(root2)
    expected2 = [1]
    print("Test Case 2 - Single Node:", "Passed" if result2 == expected2 else f"Failed (Result: {result2})")

    # Test Case 3: Complete Binary Tree
    # Tree structure:
    #       1
    #      / \
    #     2   3
    #    / \
    #   4   5
    root3 = build_tree([1, 2, 3, 4, 5])
    result3 = solution.inorderTraversal(root3)
    expected3 = [4, 2, 5, 1, 3]
    print("Test Case 3 - Complete Binary Tree:", "Passed" if result3 == expected3 else f"Failed (Result: {result3})")

    # Test Case 4: Left-Skewed Tree
    # Tree structure:
    #     1
    #    /
    #   2
    #  /
    # 3
    root4 = build_tree([1, 2, None, 3])
    result4 = solution.inorderTraversal(root4)
    expected4 = [3, 2, 1]
    print("Test Case 4 - Left-Skewed Tree:", "Passed" if result4 == expected4 else f"Failed (Result: {result4})")

    # Test Case 5: Right-Skewed Tree
    # Tree structure:
    # 1
    #  \
    #   2
    #    \
    #     3
    root5 = build_tree([1, None, 2, None, 3])
    result5 = solution.inorderTraversal(root5)
    expected5 = [1, 2, 3]
    print("Test Case 5 - Right-Skewed Tree:", "Passed" if result5 == expected5 else f"Failed (Result: {result5})")

    # Test Case 6: Unbalanced Tree
    # Tree structure:
    #       1
    #      / 
    #     2   
    #      \
    #       3
    root6 = build_tree([1, 2, None, None, 3])
    result6 = solution.inorderTraversal(root6)
    expected6 = [2, 3, 1]
    print("Test Case 6 - Unbalanced Tree:", "Passed" if result6 == expected6 else f"Failed (Result: {result6})")

# Run tests
test_inorder_traversal()

