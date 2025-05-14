package edu.scu.myheap;

import java.util.PriorityQueue;

public class No1962 {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((p,q)->q-p);
        int res=0;
        for (int value:piles){
            pq.add(value);
            res+=value;
        }
        while(k>0){
            k--;
            int temp=pq.poll();
            res-=temp;
            temp=(temp-1)/2+1;
            res+=temp;
            pq.add(temp);
        }
        return res;
    }
}
