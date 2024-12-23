import { TreeNode, preorderTraversal } from './solution';

// Test case 1: Empty Tree
test('should return an empty array for an empty tree', () => {
    const root = null;
    expect(preorderTraversal(root)).toEqual([]);
});

// Test case 2: Single Node Tree
test('should return [1] for a tree with only one node', () => {
    const root = new TreeNode(1);
    expect(preorderTraversal(root)).toEqual([1]);
});

// Test case 3: Perfect Binary Tree
test('should return [1, 2, 4, 5, 3, 6, 7] for a perfect binary tree', () => {
    const root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(7);

    expect(preorderTraversal(root)).toEqual([1, 2, 4, 5, 3, 6, 7]);
});

// Test case 4: Left Skewed Tree
test('should return [1, 2, 3, 4] for a left-skewed tree', () => {
    const root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(3);
    root.left.left.left = new TreeNode(4);

    expect(preorderTraversal(root)).toEqual([1, 2, 3, 4]);
});

// Test case 5: Right Skewed Tree
test('should return [1, 2, 3, 4] for a right-skewed tree', () => {
    const root = new TreeNode(1);
    root.right = new TreeNode(2);
    root.right.right = new TreeNode(3);
    root.right.right.right = new TreeNode(4);

    expect(preorderTraversal(root)).toEqual([1, 2, 3, 4]);
});

// Test case 6: Balanced Tree with Mixed Children
test('should return [1, 2, 4, 5, 3, 6] for a balanced tree with mixed children', () => {
    const root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.right = new TreeNode(6);

    expect(preorderTraversal(root)).toEqual([1, 2, 4, 5, 3, 6]);
});

// Test case 7: Tree with Only One Child (Right)
test('should return [1, 2, 3, 4] for a tree with only right children', () => {
    const root = new TreeNode(1);
    root.right = new TreeNode(2);
    root.right.left = new TreeNode(3);
    root.right.right = new TreeNode(4);

    expect(preorderTraversal(root)).toEqual([1, 2, 3, 4]);
});

// Test case 8: Tree with Only One Child (Left)
test('should return [1, 2, 3, 4] for a tree with only left children', () => {
    const root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(4);

    expect(preorderTraversal(root)).toEqual([1, 2, 3, 4]);
});

// Test case 9: Complex Tree with Both Left and Right Subtrees
test('should return [10, 5, 3, 7, 15, 20] for a complex tree with both left and right subtrees', () => {
    const root = new TreeNode(10);
    root.left = new TreeNode(5);
    root.right = new TreeNode(15);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(7);
    root.right.left = null;
    root.right.right = new TreeNode(20);

    expect(preorderTraversal(root)).toEqual([10, 5, 3, 7, 15, 20]);
});

// Test case 10: Tree with Duplicate Values
test('should return [1, 1, 1, 1, 1] for a tree with duplicate values', () => {
    const root = new TreeNode(1);
    root.left = new TreeNode(1);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(1);

    expect(preorderTraversal(root)).toEqual([1, 1, 1, 1, 1]);
});
