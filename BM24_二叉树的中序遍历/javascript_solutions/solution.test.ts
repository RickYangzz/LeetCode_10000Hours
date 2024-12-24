import { inorderTraversal, TreeNode } from './solution';

describe('inorderTraversal', () => {
    test('should return an empty array for a null root', () => {
        expect(inorderTraversal(null)).toEqual([]);
    });

    test('should return a single element array for a tree with only one node', () => {
        const root = new TreeNode(1);
        expect(inorderTraversal(root)).toEqual([1]);
    });

    test('should return inorder traversal for a left-skewed tree', () => {
        const root = new TreeNode(3, new TreeNode(2, new TreeNode(1)));
        expect(inorderTraversal(root)).toEqual([1, 2, 3]);
    });

    test('should return inorder traversal for a right-skewed tree', () => {
        const root = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3)));
        expect(inorderTraversal(root)).toEqual([1, 2, 3]);
    });

    test('should return inorder traversal for a balanced binary tree', () => {
        const root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        expect(inorderTraversal(root)).toEqual([1, 2, 3]);
    });

    test('should return inorder traversal for a complex binary tree', () => {
        const root = new TreeNode(1,
            null,
            new TreeNode(2,
                new TreeNode(3),
                new TreeNode(4)
            )
        );
        expect(inorderTraversal(root)).toEqual([1, 3, 2, 4]);
    });

    test('should handle a tree with duplicate values', () => {
        const root = new TreeNode(2,
            new TreeNode(2,
                new TreeNode(1)
            ),
            new TreeNode(2)
        );
        expect(inorderTraversal(root)).toEqual([1, 2, 2, 2]);
    });
});
