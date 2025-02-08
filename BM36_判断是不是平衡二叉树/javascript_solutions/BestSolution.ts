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
    const result = calculateHeight(pRoot);
    return result != -1;
}

function calculateHeight(root: TreeNode | null): number {
    if (root == null) return 0;

    const leftHeight = calculateHeight(root.left);
    if(leftHeight == -1) return -1;
    const rightHeight = calculateHeight(root.right);
    if(rightHeight == -1) return -1;

    const result = Math.abs(leftHeight - rightHeight) <= 1;
    if(result){
        return Math.max(leftHeight, rightHeight) + 1;
    }else{
        return -1;
    }
}
