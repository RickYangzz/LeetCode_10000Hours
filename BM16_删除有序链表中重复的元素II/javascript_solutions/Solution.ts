class ListNode {
    val: number
    next: ListNode | null
    constructor(val?: number, next?: ListNode | null) {
        this.val = (val === undefined ? 0 : val)
        this.next = (next === undefined ? null : next)
    }
}

/**
 * 
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * @param head ListNode类 
 * @return ListNode类
 */
export function deleteDuplicates(head: ListNode): ListNode {
    if (head == null || head.next == null) return head;

    const res = new ListNode(-1);
    res.next = head;
    let current = res;

    while (current.next && current.next.next) {
        if (current.next.val == current.next.next.val) {
            const temp = current.next.val;

            while (current.next && current.next.val == temp) {
                current.next = current.next.next;
            }
        } else {
            current = current.next;
        }
    }

    return res.next;
}
