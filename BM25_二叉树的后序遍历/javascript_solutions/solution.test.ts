// postorderTraversal.test.ts

import { postorderTraversal, TreeNode } from './solution';  // Adjust the import path as needed

describe('postorderTraversal', () => {

    // Test Case 1: Basic Test Case
    test('should return [3, 2, 1] for a basic tree', () => {
        const root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        const result = postorderTraversal(root);
        expect(result).toEqual([3, 2, 1]);
    });

    // Test Case 2: Single Node Tree
    test('should return [1] for a tree with a single node', () => {
        const root = new TreeNode(1);
        const result = postorderTraversal(root);
        expect(result).toEqual([1]);
    });

    // Test Case 3: Left Skewed Tree
    test('should return [3, 2, 1] for a left skewed tree', () => {
        const root = new TreeNode(1, new TreeNode(2, new TreeNode(3), null), null);
        const result = postorderTraversal(root);
        expect(result).toEqual([3, 2, 1]);
    });

    // Test Case 4: Right Skewed Tree
    test('should return [3, 2, 1] for a right skewed tree', () => {
        const root = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3)));
        const result = postorderTraversal(root);
        expect(result).toEqual([3, 2, 1]);
    });

    // Test Case 5: Full Binary Tree
    test('should return [4, 5, 2, 6, 7, 3, 1] for a full binary tree', () => {
        const root = new TreeNode(1, 
            new TreeNode(2, new TreeNode(4), new TreeNode(5)),
            new TreeNode(3, new TreeNode(6), new TreeNode(7))
        );
        const result = postorderTraversal(root);
        expect(result).toEqual([4, 5, 2, 6, 7, 3, 1]);
    });

    // Test Case 6: Tree with Only Left Subtree
    test('should return [3, 2, 1] for a tree with only left subtree', () => {
        const root = new TreeNode(1, new TreeNode(2, new TreeNode(3), null), null);
        const result = postorderTraversal(root);
        expect(result).toEqual([3, 2, 1]);
    });

    // Test Case 7: Tree with Only Right Subtree
    test('should return [3, 2, 1] for a tree with only right subtree', () => {
        const root = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3)));
        const result = postorderTraversal(root);
        expect(result).toEqual([3, 2, 1]);
    });

    // Test Case 8: Empty Tree
    test('should return an empty array for an empty tree', () => {
        const root = null;
        const result = postorderTraversal(root);
        expect(result).toEqual([]);
    });

    // Test Case 9: Tree with Multiple Levels
    test('should return [4, 5, 2, 3, 1] for a tree with multiple levels', () => {
        const root = new TreeNode(1, 
            new TreeNode(2, 
                new TreeNode(4),
                new TreeNode(5)
            ), 
            new TreeNode(3)
        );
        const result = postorderTraversal(root);
        expect(result).toEqual([4, 5, 2, 3, 1]);
    });

});
