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
 * @param root TreeNode类 
 * @return TreeNode类
 */
export function Serialize(root: TreeNode | null): string {
    if (root == null) return "#";

    return `${root.val},${Serialize(root.left)},${Serialize(root.right)}`;
}

export function Deserialize(str: string): TreeNode|null {
    if(str == "#") return null;

    const arr = str.split(',');

    return deserializeFunction(arr);
}

function deserializeFunction(arr: string[]): TreeNode|null {
    if(arr.length == 0) return null;

    const val: string = arr.shift() + "";
    
    if(val == "#") {
        return null;
    }

    const root = new TreeNode(Number.parseInt(val));

    root.left = deserializeFunction(arr);
    root.right = deserializeFunction(arr);

    return root;
}