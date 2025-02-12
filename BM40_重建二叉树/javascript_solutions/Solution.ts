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

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * 
 * @param preOrder int整型一维数组 
 * @param vinOrder int整型一维数组 
 * @return TreeNode类
 */
export function reConstructBinaryTree(preOrder: number[], vinOrder: number[]): TreeNode|null {
    if(preOrder.length==0 || vinOrder.length == 0) return null;

    const rootVal = preOrder[0];

    const root = new TreeNode(rootVal);

    for (let i = 0; i < vinOrder.length; i++) {
        if(vinOrder[i] == rootVal){
            root.left = reConstructBinaryTree(
                preOrder.slice(1, i+1), 
                vinOrder.slice(0, i)
            );
            root.right = reConstructBinaryTree(
                preOrder.slice(i+1, preOrder.length),
                vinOrder.slice(i+1, vinOrder.length)
            )
            break;
        }
    }

    return root;
}
