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
 * @param root TreeNode类 
 * @param p int整型 
 * @param q int整型 
 * @return int整型
 */
export function lowestCommonAncestor(root: TreeNode, p: number, q: number): number {
    const pathP = getTargetPath(root, p);
    const pathQ = getTargetPath(root, q);

    let i = 0;
    while(i < pathP.length && i < pathQ.length){
        if(pathP[i] == pathQ[i]){
            i++
        }else{
            break;
        }
    }

    return pathP[i-1];
}

function getTargetPath(root: TreeNode|null, target: number): number[]{
    const result: number[] = [];
    if(!root) return result;

    while(root && root.val != target){
        result.push(root.val);

        if(target > root.val){
            root = root.right;
        }else{
            root = root.left;
        }
    }

    if(root) result.push(root.val);

    return result;
}
