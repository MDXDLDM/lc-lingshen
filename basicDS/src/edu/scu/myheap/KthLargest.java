package edu.scu.myheap;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class KthLargest {
    int k;
    PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq=new PriorityQueue<>();
        for (int value:nums){
            add(value);
        }
    }

    public int add(int val) {
        pq.add(val);
        if (pq.size()>k){
            pq.poll();
        }
        return pq.peek();
    }
}
