export class TreeNode {
    val: number
    left: TreeNode | null
    right: TreeNode | null
    constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
        this.val = (val===undefined ? 0 : val)
        this.left = (left===undefined ? null : left)
        this.right = (right===undefined ? null : right)
    }
}

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * 
 * @param root TreeNode类 
 * @return int整型一维数组
 */
export function postorderTraversal(root: TreeNode | null): number[] {
    if (!root) return [];

    const result: number[] = [];
    const stack: TreeNode[] = [];
    let pre: TreeNode | null = null;
    
    while(root || stack.length){
        while(root){
            stack.push(root);
            root = root.left;
        }
        
        const topNode: TreeNode | undefined =  stack.pop();
        if (topNode === undefined) break; // 处理栈为空的情况
        
        if (topNode.right == null || topNode.right == pre){
            result.push(topNode.val);
            pre = topNode;
        }else{
            stack.push(topNode);
            root = topNode.right;
        }
    }

    return result;
}
