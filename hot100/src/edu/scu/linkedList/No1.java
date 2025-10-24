package edu.scu.linkedList;

public class No1 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //不使用额外空间
//        int sizeA = 0, sizeB = 0;
//        ListNode currA = headA;ListNode currB = headB;
//        while (currA != null) {
//            sizeA++;
//            currA= currA.next;
//        }
//        while (currB != null) {
//            sizeB++;
//            currB= currB.next;
//        }
//        currA = headA;currB = headB;
//        while(sizeA>sizeB){
//            currA = currA.next;
//            sizeA--;
//        }
//        while(sizeB>sizeA){
//            currB = currB.next;
//            sizeB--;
//        }
//        while(currA!=null && currB!=null){
//            if(currA==currB){
//                return currA;
//            }
//            currA = currA.next;
//            currB = currB.next;
//        }
//        return null;
        ListNode currA = headA;
        ListNode currB = headB;
        while (currA != currB) {
            currA = currA == null ? headB : currA.next;
            currB = currB == null ? headA : currB.next;
        }
        return currA;
    }
}
