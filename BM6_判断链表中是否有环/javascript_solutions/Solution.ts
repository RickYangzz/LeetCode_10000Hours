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
 * @param head ListNode类 
 * @return bool布尔型
 */
export function hasCycle(head: ListNode): boolean {
    if(head == null) return false;

    let fast: ListNode | null = head;
    let slow: ListNode | null = head;

    while(fast!=null && fast.next != null && slow != null){
        fast = fast.next.next;
        slow = slow.next;

        if(fast == slow) return true;
    }

    return false;
}