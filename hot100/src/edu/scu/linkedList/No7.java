package edu.scu.linkedList;

public class No7 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode currA=l1;
//        ListNode currB=l2;
//        int carry=0;ListNode prev=null;
//        while(currA!=null && currB!=null){
//            int sum=currA.val+currB.val+carry;
//            carry=sum/10;
//            currB.val=sum%10;
//            currA=currA.next;
//            prev=currB;
//            currB=currB.next;
//        }
//        currB=currA==null?currB:currA;
//        prev.next=currB;
//        while(currB!=null){
//            int sum=carry+currB.val;
//            carry=sum/10;
//            currB.val=sum%10;
//            prev=currB;
//            currB=currB.next;
//        }
//        if (carry!=0){
//            currB=new ListNode(carry);
//            prev.next=currB;
//        }
//        return l2;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;
        while (l1 != null || l2 != null||carry != 0) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            curr.next = new ListNode(carry % 10);
            carry = carry / 10;
            curr = curr.next;
        }
        return dummy.next;
    }
}
