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

let pre = Number.MIN_SAFE_INTEGER;

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * 
 * @param root TreeNode类 
 * @return bool布尔型
 */
export function isValidBST(root: TreeNode|null): boolean {
    if(root == null) return true;

    if(!isValidBST(root.left)) return false;
    if(root.val < pre) return false;

    pre = root.val;

    return isValidBST(root.right);
}
