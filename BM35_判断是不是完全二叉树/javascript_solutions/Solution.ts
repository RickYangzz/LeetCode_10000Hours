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
 * 给定一个二叉树，确定他是否是一个完全二叉树。
 * 
 * @param root TreeNode类 
 * @return bool布尔型
 */
export function isCompleteTree(root: TreeNode): boolean {
    const queue: (TreeNode | null)[] =  [];
    let isFinished = false;
    queue.push(root);

    while(queue.length > 0){
        const head = queue.shift();

        if(head == null){
            isFinished = true;
            continue;
        }

        if(isFinished){
            return false;
        }

        queue.push(head.left);
        queue.push(head.right);
    }

    return true;
}
