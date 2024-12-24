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
export function inorderTraversal(root: TreeNode | null): number[] {
    if (!root) return [];

    const result: number[] = [];
    const stack: TreeNode[] = [];


    while (root || stack.length) {
        while (root) {
            stack.push(root);
            root = root.left;
        }

        const topNode: TreeNode | undefined = stack.pop();
        if (topNode) {
            result.push(topNode.val);
            root = topNode.right;
        }
    }

    return result;
}
