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

let head: TreeNode | null | undefined = null;
let pre: TreeNode | null | undefined = null;

export function Convert(pRootOfTree: TreeNode | null): TreeNode | null | undefined {
    if (!pRootOfTree) return null;

    Convert(pRootOfTree.left);

    if (!head && !pre) {
        head = pRootOfTree;
        pre = pRootOfTree;
    } else {
        if (!pre) throw new Error("神学事件");
        pre.right = pRootOfTree;
        pRootOfTree.left = pre;

        pre = pRootOfTree;
    }

    Convert(pRootOfTree.right);

    return head;
}