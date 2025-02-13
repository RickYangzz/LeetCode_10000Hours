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

function buildTree(preOrder: number[], inOrder: number[]): TreeNode|null{
    if(preOrder.length == 0 || inOrder.length == 0) return null;

    const rootVal = preOrder[0];
    const root = new TreeNode(rootVal);

    for (let i = 0; i < inOrder.length; i++) {
        if(inOrder[i] == rootVal){
            root.left = buildTree(preOrder.slice(1, i+1), inOrder.slice(0,i));
            root.right = buildTree(
                preOrder.slice(i+1, preOrder.length), 
                inOrder.slice(i+1, inOrder.length) 
            )
            break;
        }
    }

    return root;
}

function getRightView(root: TreeNode|null): number[] {
    if(root == null) return [];

    const result: number[] = [];
    const queue: TreeNode[] = [];
    queue.push(root);

    while(queue.length > 0){
        let size = queue.length;

        while(size > 0){
            const top = queue.shift();
            size--;
            if(top?.left != null) queue.push(top.left);
            if(top?.right != null) queue.push(top.right);

            if(size == 0 && top){
                result.push(top.val);
            }
        }
    }

    return result;
}

export function solve(preOrder: number[], inOrder: number[]): number[] {
    const root = buildTree(preOrder, inOrder);
    return getRightView(root);
}