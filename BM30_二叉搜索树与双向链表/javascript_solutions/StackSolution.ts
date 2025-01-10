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
 * @param pRootOfTree TreeNode类 
 * @return TreeNode类
 */
export function Convert(pRootOfTree: TreeNode | null): TreeNode | null | undefined {
    if (!pRootOfTree) return null;

    let head: TreeNode | null | undefined = null;
    let pre: TreeNode | null | undefined = null;
    const stack: TreeNode[] = [];

    while (stack.length || pRootOfTree) {
        while (pRootOfTree) {
            stack.push(pRootOfTree);
            pRootOfTree = pRootOfTree.left;
        }

        const top = stack.pop();
        if (!top) throw new Error("出现神学事件，程序崩溃");

        if (!head || !pre) {
            head = top;
            pre = top;
        } else {
            pre.right = top;
            top.left = pre;
            pre = top;
        }

        pRootOfTree = top.right;
    }

    return head;
}