package BM8_链表中倒数最后k个结点.java_solutions;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param pHead ListNode类 
     * @param k int整型 
     * @return ListNode类
     */
    public ListNode FindKthToTail (ListNode pHead, int k) {
        ListNode fast = pHead;
        ListNode slow = pHead;

        while(k>0){
            k--;
            if(fast != null) {
                fast = fast.next;
            }else{
                return null;
            }
        }

        while(fast != null){
            fast =fast.next;
            slow = slow.next;
        }

        return slow;
    }
}