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
 * @param head ListNode类 the head
 * @return bool布尔型
 */
export function isPail(head: ListNode | null): boolean {
    let newHead = copyList(head);
    let tail = reverseList(newHead);

    while(tail && head){
        if(tail.val != head.val){
            return false;
        }

        tail = tail.next;
        head = head.next;
    }

    return true;
}

function copyList(head: ListNode | null): ListNode | null {
    if (head == null) return null;

    let newHead = new ListNode(head.val);
    let current = newHead;

    head = head.next;
    while (head != null) {
        current.next = new ListNode(head.val);

        current = current.next;
        head = head.next;
    }

    return newHead;
}

function reverseList(head: ListNode | null): ListNode | null {
    if (head == null) return null;

    let current: ListNode | null = head;
    let pre: ListNode | null = null;

    while (current != null) {
        const temp = current.next;
        current.next = pre;

        pre = current;
        current = temp;
    }

    return pre;
}
