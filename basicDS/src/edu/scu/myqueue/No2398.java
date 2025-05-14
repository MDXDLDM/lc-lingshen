package edu.scu.myqueue;

import java.util.PriorityQueue;

public class No2398 {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int firstindex=0;int lastindex=0;
        long sumtime=0; long temp;
        int max=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((p,q)->q-p);
        while(lastindex<chargeTimes.length){
            sumtime+=runningCosts[lastindex];
            pq.add(chargeTimes[lastindex]);
            temp=pq.peek()+sumtime*(lastindex-firstindex+1);
            while(temp>budget&&firstindex<=lastindex){
                pq.remove(chargeTimes[firstindex]);
                sumtime-=runningCosts[firstindex];
                if (lastindex==firstindex){
                    firstindex++;
                    temp=0;
                    break;
                }
                temp=pq.peek()+sumtime*(lastindex-firstindex+1);
                firstindex++;
            }
            max=Math.max(max,(lastindex-firstindex+1));
            lastindex++;
        }
        return max;
    }
}
