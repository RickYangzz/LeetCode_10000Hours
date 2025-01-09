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
    if(pHead1 == null) return pHead2;
    if(pHead2 == null) return pHead1;
    
    if(pHead1.val <= pHead2.val){
        pHead1.next = Merge(pHead1.next, pHead2);
        return pHead1;
    }else{
        pHead2.next = Merge(pHead1, pHead2.next);
        return pHead2;
    }
}
