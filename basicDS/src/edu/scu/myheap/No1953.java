package edu.scu.myheap;

import java.util.Collections;
import java.util.PriorityQueue;

public class No1953 {
    public long numberOfWeeks(int[] milestones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int milestone : milestones) {
            pq.add(milestone);
        }
        long res=0;
        boolean flag=false;
        while (pq.size() > 1) {
            int max=pq.poll();
            int secmax=pq.poll();
            res+=secmax;
            max-=secmax;
            if (max>0){
                pq.add(max);
            }
        }
        if (!pq.isEmpty()){
            res++;
        }
        return res;
    }
}
