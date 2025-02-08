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
 * @param head1 ListNode类 
 * @param head2 ListNode类 
 * @return ListNode类
 */
export function addInList(head1: ListNode | null, head2: ListNode | null): ListNode | null {
    if(head1==null) return head2;
    if(head2==null) return head1;

    head1 = reverseLinkedList(head1);
    head2 = reverseLinkedList(head2);

    const result = new ListNode(-1);
    let tail = result;
    let carry = 0;

    while(head1 != null || head2 != null || carry > 0){
        const a = head1 ? head1.val : 0;
        const b = head2 ? head2.val : 0;
        let value = a + b + carry;

        carry = Math.floor(value / 10);
        value = value % 10;
        tail.next = new ListNode(value);

        head1 = head1 ? head1.next : null;
        head2 = head2 ? head2.next : null;
        tail = tail.next
    }

    return reverseLinkedList(result.next);
}

function reverseLinkedList(head: ListNode|null): ListNode|null{
    if(head == null) return null;

    let current: ListNode | null = head;
    let pre: ListNode | null  = null;

    while(current != null){
        const temp = current.next;
        current.next = pre;

        pre = current;
        current = temp;
    }

    return pre;
}
