function StackSolution(root: TreeNode | null): number[] {
    if (root == null) return [];

    const stack: TreeNode[] = [];
    const result: number[] = [];

    while(root || stack.length){
        while(root){
            stack.push(root);
            root = root.left;
        }

        const top = stack.pop();
        if(!top) throw new Error("Data error");
        result.push(top.val);
        root = top.right;
    }

    return result;
};

