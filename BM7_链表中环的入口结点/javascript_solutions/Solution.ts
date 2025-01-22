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
 * @param pHead ListNode类 
 * @return ListNode类
 */
export function EntryNodeOfLoop(pHead: ListNode): ListNode | null {
    let fast: ListNode | null = pHead;
    let slow: ListNode | null = pHead;

    while (fast != null && fast.next != null && slow != null) {
        fast = fast.next.next;
        slow = slow.next;

        if (fast == slow) {
            fast = pHead;
            while (fast != slow && fast != null && slow != null) {
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }
    }

    return null;
}
