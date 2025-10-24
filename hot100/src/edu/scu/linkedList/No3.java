package edu.scu.linkedList;

public class No3 {
    public boolean isPalindrome(ListNode head) {
        ListNode mid=middleNode(head);
        ListNode newMidHead=reverseList(mid);
        while(newMidHead!=null){
            if(head.val!=newMidHead.val) return false;
            head=head.next;
            newMidHead=newMidHead.next;
        }
        return true;
    }
    public ListNode reverseList(ListNode head) {
        if (head==null||head.next==null) return head;
        ListNode newPrev = reverseList(head.next);//拿到未来的头节点
        head.next.next=head;
        head.next = null;
        return newPrev;
    }
    public ListNode middleNode(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}
