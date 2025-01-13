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
 * @param t1 TreeNode类 
 * @param t2 TreeNode类 
 * @return TreeNode类
 */
export function mergeTrees(t1: TreeNode | null, t2: TreeNode|null): TreeNode | null {
    if(t1 == null && t2 == null) return null;
    if(t1 == null) return t2;
    if(t2 == null) return t1;

    const head = new TreeNode(t1.val + t2.val);
    head.left = mergeTrees(t1.left, t2.left);
    head.right = mergeTrees(t1.right, t2.right);

    return head;
}
