function Solution(root: TreeNode | null): number[] {
    const result: number[] = [];

    const inOrder = (root: TreeNode | null): void =>{
        if (root == null) return;

        inOrder(root.left);
        result.push(root.val);
        inOrder(root.right);
    }

    inOrder(root);

    return result;
};

