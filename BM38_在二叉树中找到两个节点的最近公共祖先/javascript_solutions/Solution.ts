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

let flag = false;

export function lowestCommonAncestor(root: TreeNode, o1: number, o2: number): number {
    const pathA = [];
    const pathB = [];

    dfs(root, o1, pathA);
    flag = false;
    dfs(root, o2, pathB);

    let res = 0 ;
    for (let i = 0; i < pathA.length && pathB.length; i++) {
        const a = pathA[i];
        const b = pathB[i];
        if(a==b){
            res = a;
        }else{
            break;
        }
    }

    return res;
}

function dfs(root: TreeNode|null, target: number, path: number[]){
    if(flag || root == null) return;

    path.push(root.val);

    if(root.val == target){
        flag = true;
        return;
    }

    dfs(root.left, target, path);
    dfs(root.right, target, path);

    if(flag) return;

    path.pop();
}
