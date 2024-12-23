export class TreeNode {
    val: number
    left: TreeNode | null
    right: TreeNode | null
    constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
        this.val = (val === undefined ? 0 : val)
        this.left = (left === undefined ? null : left)
        this.right = (right === undefined ? null : right)
    }
}

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * 
 * @param root TreeNode类 
 * @return int整型一维数组
 */
export function preorderTraversal(root: TreeNode | null): number[] {
    if (!root) return [];

    const result: number[] = [];
    const stack: TreeNode[] = [];
    stack.push(root);

    while (stack.length) {
        const topNode: (TreeNode | undefined) = stack.pop();
        if (!topNode) continue;

        result.push(topNode.val);
        if (topNode.right) stack.push(topNode.right);
        if (topNode.left) stack.push(topNode.left);
    }

    return result;
}
