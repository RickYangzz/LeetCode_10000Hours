class ListNode {
    val: number
    next: ListNode | null
    constructor(val?: number, next?: ListNode | null) {
        this.val = (val === undefined ? 0 : val)
        this.next = (next === undefined ? null : next)
    }
}

export function sortInList(head: ListNode | null): ListNode | null {
    if (head == null || head.next == null) return head;

    let left = head;
    let mid = head.next;
    let right = head.next.next;

    while (
        right && right.next &&
        left && left.next &&
        mid && mid.next
    ) {
        left = left.next;
        mid = mid.next;
        right = right.next.next;
    }

    left.next = null;

    return merge(sortInList(head), sortInList(mid));
}

function merge(first: ListNode | null, second: ListNode | null): ListNode | null {
    const result = new ListNode(-1);
    let tail = result;

    while (first && second) {
        if (first.val <= second.val) {
            tail.next = first;
            first = first.next;
        } else {
            tail.next = second;
            second = second.next;
        }

        tail = tail.next;
    }

    if (first) {
        tail.next = first;
    }

    if (second) {
        tail.next = second;
    }

    return result.next;
}