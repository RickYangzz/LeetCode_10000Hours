from solution import TreeNode, Solution

# Helper function to run the test cases
def run_test_case(root, expected_output):
    solution = Solution()
    real_output = solution.postorderTraversal(root)
    
    print(f"Expected Output: {expected_output}")
    print(f"Real Output: {real_output}")
    
    if real_output == expected_output:
        print("Result: Passed\n")
    else:
        print("Result: Failed\n")


# Test Case 1: Simple Binary Tree
# Tree structure:
#     1
#    / \
#   2   3

root = TreeNode(1)
root.left = TreeNode(2)
root.right = TreeNode(3)
expected_output = [2, 3, 1]
run_test_case(root, expected_output)


# Test Case 2: Single Node Tree
# Tree structure:
#     1

root = TreeNode(1)
expected_output = [1]
run_test_case(root, expected_output)


# Test Case 3: Empty Tree
root = None
expected_output = []
run_test_case(root, expected_output)


# Test Case 4: Left-skewed Tree
# Tree structure:
#     1
#    /
#   2
#  /
# 3

root = TreeNode(1)
root.left = TreeNode(2)
root.left.left = TreeNode(3)
expected_output = [3, 2, 1]
run_test_case(root, expected_output)


# Test Case 5: Right-skewed Tree
# Tree structure:
#     1
#      \
#       2
#        \
#         3

root = TreeNode(1)
root.right = TreeNode(2)
root.right.right = TreeNode(3)
expected_output = [3, 2, 1]
run_test_case(root, expected_output)


# Test Case 6: Complex Tree
# Tree structure:
#        1
#       / \
#      2   3
#     / \    \
#    4   5    6

root = TreeNode(1)
root.left = TreeNode(2)
root.right = TreeNode(3)
root.left.left = TreeNode(4)
root.left.right = TreeNode(5)
root.right.right = TreeNode(6)
expected_output = [4, 5, 2, 6, 3, 1]
run_test_case(root, expected_output)


# Test Case 7: Tree with Only Right Subtree
# Tree structure:
#     1
#      \
#       2
#        \
#         3
#          \
#           4

root = TreeNode(1)
root.right = TreeNode(2)
root.right.right = TreeNode(3)
root.right.right.right = TreeNode(4)
expected_output = [4, 3, 2, 1]
run_test_case(root, expected_output)
