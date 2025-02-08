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
 * @param pHead1 ListNode类 
 * @param pHead2 ListNode类 
 * @return ListNode类
 */
export function FindFirstCommonNode(pHead1: ListNode, pHead2: ListNode): ListNode | null {
    let a: ListNode | null = pHead1;
    let b: ListNode | null = pHead2;

    while(a != b){
        a = a != null ? a.next : pHead2;
        b = b != null ? b.next : pHead1;
    }

    return a;
}