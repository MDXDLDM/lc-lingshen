package edu.scu.monotonicStack;

import java.util.Stack;

public class No1019 {
    public int[] nextLargerNodes(ListNode head) {
        int len=0;
        ListNode cur = head;
        while(cur!=null){
            cur=cur.next;
            len++;
        }
        int[] res = new int[len];
        cur=head;
        int index=0;
        Stack<int[]> stack = new Stack<int[]>();
        while(cur!=null){
            int val = cur.val;
            while(!stack.isEmpty()&&stack.peek()[1]<val){
                int[] tmp = stack.pop();
                res[tmp[0]]=val;
            }
            stack.push(new int[]{index,val});
            index++;
            cur=cur.next;
        }
        return res;
    }
    private static class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
