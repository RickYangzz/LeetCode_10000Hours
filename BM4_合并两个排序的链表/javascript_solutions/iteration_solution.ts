class ListNode {
    val: number
    next: ListNode | null
    constructor(val?: number, next?: ListNode | null) {
        this.val = (val === undefined ? 0 : val)
        this.next = (next === undefined ? null : next)
    }
}

/**
 * 输入两个递增的链表，单个链表的长度为n，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 
 * @param pHead1 ListNode类 
 * @param pHead2 ListNode类 
 * @return ListNode类
 */
export function Merge(pHead1: ListNode | null, pHead2: ListNode | null): ListNode | null {
    const resultHead = new ListNode(-1);

    let current = resultHead;
    let head1: ListNode | null = pHead1;
    let head2: ListNode | null = pHead2;

    while(head1 && head2){
        if(head1.val <= head2.val){
            current.next = head1;
            head1 = head1.next;
        }else{
            current.next = head2;
            head2 = head2.next;
        }
        
        current = current.next;
    }
    current.next = head1 ? head1 : head2;

    return resultHead.next;
}
