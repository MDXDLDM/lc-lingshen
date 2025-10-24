package edu.scu.linkedList;

public class No2 {
    public ListNode reverseList(ListNode head) {
//        ListNode prev = null;
//        ListNode curr = head;
//        while (curr != null) {
//            ListNode next = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = next;
//        }
//        return prev;
        if (head==null||head.next==null) return head;
        ListNode newPrev = reverseList(head.next);//拿到未来的头节点
        head.next.next=head;
        head.next = null;
        return newPrev;
    }
}
