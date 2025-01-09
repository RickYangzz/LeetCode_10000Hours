package BM4_合并两个排序的链表.java_solutions;

public class IterationSolution {
    /**
     * 输入两个递增的链表，单个链表的长度为n，合并这两个链表并使新链表中的节点仍然是递增排序的。
     *
     * 
     * @param pHead1 ListNode类 
     * @param pHead2 ListNode类 
     * @return ListNode类
     */
    public ListNode Merge (ListNode pHead1, ListNode pHead2) {
        ListNode resultHead = new ListNode(-1);
        ListNode current = resultHead;
        while(pHead1 != null && pHead2 != null) {
            if(pHead1.val <= pHead2.val){
                current.next = pHead1;
                pHead1 = pHead1.next;
            }else{
                current.next = pHead2;
                pHead2 = pHead2.next;
            }

            current = current.next;
        }

        current.next = pHead1 != null ? pHead1 : pHead2;

        return resultHead.next;
    }
}