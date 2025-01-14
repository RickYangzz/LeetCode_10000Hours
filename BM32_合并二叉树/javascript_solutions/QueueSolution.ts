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
 * 
 * @param t1 TreeNode类 
 * @param t2 TreeNode类 
 * @return TreeNode类
 */
export function mergeTrees(t1: TreeNode | null, t2: TreeNode|null): TreeNode | null {
    if(t1 == null && t2 == null) return null;
    if(t1 == null) return t2;
    if(t2 == null) return t1;

    const q: TreeNode[] = [];
    const q1: TreeNode[] = [];
    const q2: TreeNode[] = [];

    const head = new TreeNode(t1.val + t2.val);
    q.push(head);
    q1.push(t1);
    q2.push(t2);

    while(q.length > 0 && q1.length > 0 && q2.length > 0){
        const total = q.shift();
        const node1 = q1.shift();
        const node2 = q2.shift();

        if(!total || !node1 || !node2) throw new Error("数据异常");

        if(node1.left && node2.left){
            total.left = new TreeNode(node1.left.val + node2.left.val);
            q.push(total.left);
            q1.push(node1.left);
            q2.push(node2.left);
        }else if(node1.left){
            total.left = node1.left;
        }else if(node2.left){
            total.left = node2.left;
        }

        if(node1.right && node2.right){
            total.right = new TreeNode(node1.right.val + node2.right.val);
            q.push(total.right);
            q1.push(node1.right);
            q2.push(node2.right);
        }else if(node1.right){
            total.right = node1.right;
        }else if(node2.right){
            total.right = node2.right;
        }
    }

    return head;
}
