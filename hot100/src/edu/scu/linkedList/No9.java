package edu.scu.linkedList;

public class No9 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0,head);
        ListNode prev = dummy;
        ListNode curr=head;
        while (curr!=null&&curr.next != null) {
            ListNode temp = curr.next;
            prev.next = temp;
            curr.next = temp.next;
            temp.next = curr;
            prev=curr;
            curr=curr.next;
        }
        return dummy.next;
    }
}
