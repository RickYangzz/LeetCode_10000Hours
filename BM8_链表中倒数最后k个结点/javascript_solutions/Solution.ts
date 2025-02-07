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
 * @param k int整型 
 * @return ListNode类
 */
export function FindKthToTail(pHead: ListNode, k: number): ListNode | null {
    let fast: ListNode | null = pHead;
    let slow: ListNode | null = pHead;

    while(k>0){
        k--;
        if(fast){
            fast = fast.next;
        }else{
            return fast;
        }
    }

    while(fast && slow){
        fast = fast.next;
        slow = slow.next;
    }

    return slow;
}
