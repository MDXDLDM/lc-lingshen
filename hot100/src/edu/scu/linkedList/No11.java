package edu.scu.linkedList;

public class No11 {
    public Node copyRandomList(Node head) {
//        Node dummy = new Node(0);
//        Node cur = dummy;
//        Node copy = head;
//        while (copy != null) {
//            Node newNode=new Node(copy.val);
//            cur.next = newNode;
//            cur=cur.next;
//            copy=copy.next;
//        }
//        //复制random
//        Node oldPointer=head;
//        Node newPointer=dummy.next;
//        while (oldPointer != null) {
//            Node randomNode=oldPointer.random;
//            Node oldMove=head;
//            Node newMove=dummy.next;
//            while(oldMove!=randomNode){
//                newMove=newMove.next;
//                oldMove=oldMove.next;
//            }
//            newPointer.random=newMove;
//            oldPointer=oldPointer.next;
//            newPointer=newPointer.next;
//        }
//        return dummy.next;
        if (head == null) return null;
        Node curr = head;
        while (curr != null) {
            Node fake=new Node(curr.val);
            fake.next=curr.next;
            curr.next = fake;
            curr = fake.next;
        }
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random=curr.random.next;
            }
            curr = curr.next.next;
        }
        curr = head;
        Node newHead = head.next;
        Node res=newHead;
        while (curr != null) {
            curr.next=newHead.next;
            if (newHead.next != null) {
                newHead.next=newHead.next.next;
            }
            curr = curr.next;
            newHead=newHead.next;
        }
        return res;
    }
}
