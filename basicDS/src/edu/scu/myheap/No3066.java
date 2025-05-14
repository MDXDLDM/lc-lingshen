package edu.scu.myheap;

import java.util.PriorityQueue;

public class No3066 {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int value:nums){
            pq.add((long)value);
        }
        int res=0;
        while(pq.peek()<k){
            long a=pq.poll();
            long b=pq.poll();
            pq.add(Math.min(a,b)*2+Math.max(a,b));
            res++;
        }
        return res;
    }
}
