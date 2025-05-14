package edu.scu.myheap;

import java.util.PriorityQueue;

public class No23 {
    private static class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (ListNode node : lists) {
            while (node != null) {
                pq.add(node.val);
                node = node.next;
            }
        }
        ListNode head = new ListNode();
        ListNode cur = head;
        while (!pq.isEmpty()) {
            cur.next=new ListNode(pq.poll());
            cur=cur.next;
        }
        return head.next;
    }
}
