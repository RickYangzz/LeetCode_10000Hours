class TreeNode {
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
 * @return int整型
 */
export function maxDepth(root: TreeNode): number {
    if (root == null) return 0;

    let result = 0;

    const queue = [root];

    while (queue.length) {
        const size = queue.length;

        for (let index = 0; index < size; index++) {
            const node = queue.pop();

            if(node?.left) queue.unshift(node?.left);
            if(node?.right) queue.unshift(node?.right);
        }

        result++;
    }

    return result;
}
