package edu.scu.linkedList;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class No13 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
//        for(int step=1; step<lists.length; step*=2) {
//            for(int i=0;i<lists.length-step;i+=step*2) {
//                lists[i]=mergeTwoLists(lists[i], lists[i+step]);
//            }
//        }
//        return lists[0];
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length,(p,q)->Integer.compare(p.val,q.val));
        for(ListNode l : lists){
            if(l != null) pq.add(l);
        }
        ListNode dummy=new ListNode(0);
        ListNode cur=dummy;
        while(!pq.isEmpty()){
            ListNode temp=pq.poll();
            cur.next=temp;
            if(temp.next!=null){
                pq.add(temp.next);
            }
            cur=cur.next;
        }
        return dummy.next;
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode fakeHead = new ListNode(0);
        ListNode dummy = fakeHead;
        while (list1 != null && list2 != null) {
            if(list1.val<list2.val){
                dummy.next = list1;
                list1 = list1.next;
            }else{
                dummy.next = list2;
                list2 = list2.next;
            }
            dummy = dummy.next;
        }
        dummy.next = list1 == null ? list2 : list1;
        return fakeHead.next;
    }
}
