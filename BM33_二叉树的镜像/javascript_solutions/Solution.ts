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
 * @param pRoot TreeNode类 
 * @return TreeNode类
 */
export function Mirror(pRoot: TreeNode | null): TreeNode | null {
    if(pRoot == null) return null;

    const left: TreeNode | null = pRoot.left;
    const right: TreeNode | null = pRoot.right;

    pRoot.right = Mirror(left);
    pRoot.left = Mirror(right);

    return pRoot;
}
