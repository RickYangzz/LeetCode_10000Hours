class ListNode {
    val: number
    next: ListNode | null
    constructor(val?: number, next?: ListNode | null) {
        this.val = (val===undefined ? 0 : val)
        this.next = (next===undefined ? null : next)
    }
}

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * 
 * @param head ListNode类 
 * @param m int整型 
 * @param n int整型 
 * @return ListNode类
 */
export function reverseBetween(head: ListNode, m: number, n: number): ListNode {
    if(n <= m) return head;

    const dummy: ListNode = new ListNode(0);
    dummy.next = head;

    let pre: ListNode = dummy;
    for (let index = 1; index < m; index++) {
        if(pre.next) pre = pre.next;
    }

    const current = pre.next;

    for (let index = 1; index <= n-m; index++) {
        if(!current) throw new Error("参数head不符合规范");
        const target = current.next;

        if(!target) throw new Error("参数head不符合规范");
        current.next = target.next;

        target.next = pre.next;
        pre.next = target;
    }

    return dummy.next;
}
