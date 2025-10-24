package edu.scu.linkedList;

public class No6 {
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
