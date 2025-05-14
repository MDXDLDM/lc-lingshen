package edu.scu.myheap;

import java.util.PriorityQueue;

public class No2530 {
    public long maxKelements(int[] nums, int k) {
        long res=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((p,q)->q-p);
        for(int value:nums){
            pq.add(value);
        }
        while(k>0){
            k--;
            int temp=pq.poll();
            res+=temp;
            temp=(temp+1)/3;
            pq.add(temp);
        }
        return res;
    }
}
