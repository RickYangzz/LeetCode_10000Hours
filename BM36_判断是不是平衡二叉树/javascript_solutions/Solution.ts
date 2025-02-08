class TreeNode {
     val: number
     left: TreeNode | null
     right: TreeNode | null
     constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
         this.val = (val===undefined ? 0 : val)
         this.left = (left===undefined ? null : left)
         this.right = (right===undefined ? null : right)
     }
}

export function IsBalanced_Solution(pRoot: TreeNode): boolean {
    calculateHeight(pRoot);
    return judge(pRoot);
}

const map = new Map();

function calculateHeight(root: TreeNode | null): number {
    if (root == null) return 0;

    const leftHeight = calculateHeight(root.left);
    const rightHeight = calculateHeight(root.right);
    const rootHeight = Math.max(leftHeight, rightHeight) + 1;

    map.set(root, rootHeight);
    return rootHeight;
}

function judge(root: TreeNode | null): boolean {
    if(root == null) return true;

    const leftHeight = root.left == null ? 0 : map.get(root.left);
    const rightHeight = root.right == null ? 0 : map.get(root.right);

    const result = Math.abs(leftHeight - rightHeight) <= 1;
    return result && judge(root.left) && judge(root.right);
}
