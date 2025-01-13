class ListNode {
    val: number
    next: ListNode | null
    constructor(val?: number, next?: ListNode | null) {
        this.val = (val === undefined ? 0 : val)
        this.next = (next === undefined ? null : next)
    }
}

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * 
 * @param lists ListNode类一维数组 
 * @return ListNode类
 */
export function mergeKLists(lists: ListNode[]): ListNode|null {
    if(lists.length == 0) return null;
    if(lists.length == 1) return lists[0];

    const middle = lists.length / 2;
    let left = mergeKLists(lists.slice(0, middle));
    let right = mergeKLists(lists.slice(middle, lists.length));

    const res = new ListNode(-1);
    let head = res;

    while(left != null && right != null){
        if(left.val <= right.val){
            head.next = left;
            head = head.next;
            left = left.next;
        }else{
            head.next = right;
            head = head.next;
            right = right.next;
        }
    }
    
    if(left != null){
        head.next = left;
    }

    if(right != null) {
        head.next = right;
    }

    return res.next;
}
