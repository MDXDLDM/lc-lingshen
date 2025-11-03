package edu.scu.linkedList;

public class No10 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0,head);
        ListNode res = dummy;
        int count=0;
        ListNode next=dummy.next;
        while(dummy!=null){
            ListNode start=next;
            ListNode cur=start;
            while(count<k-1&&cur!=null){
                cur=cur.next;
                count++;
            }
            if(cur!=null){
                next=cur.next;
            }
            count=0;
            dummy=reverse(dummy,start,cur);
        }
        return res.next;
    }
    private ListNode reverse(ListNode dummy,ListNode head, ListNode tail) {
        if(tail==null){
            dummy.next = head;
            return null;
        }
        ListNode prev = null;
        ListNode cur = head;
        ListNode judge=tail.next;
        while(cur!=judge){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        dummy.next=tail;
        return head;
    }
}
