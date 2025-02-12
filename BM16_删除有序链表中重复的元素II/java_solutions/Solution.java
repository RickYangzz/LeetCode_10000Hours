package BM16_删除有序链表中重复的元素II.java_solutions;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param head ListNode类 
     * @return ListNode类
     */
    public ListNode deleteDuplicates (ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode current = res;

        while(current.next != null && current.next.next != null){
            if(current.next.val == current.next.next.val){
                int temp = current.next.val;
            
                while(current.next != null && current.next.val == temp){
                    current.next = current.next.next;
                }
            }else{
                current = current.next;
            }
        }

        return res.next;
    }
}