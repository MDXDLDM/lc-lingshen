package edu.scu.myheap;

import java.util.PriorityQueue;

public class No2233 {
    public int maximumProduct(int[] nums, int k) {
        long res=1;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for (int value:nums){
            pq.add(value);
        }
        while(k>0){
            k--;
            pq.add(pq.poll()+1);
        }
        while(pq.size()>0){
            res*=pq.poll();
            res%=1000000007;
        }
        return (int)(res%(1e9+7));
    }
}
