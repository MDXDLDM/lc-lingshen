package edu.scu.myheap;

import java.util.PriorityQueue;

public class No1705 {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int res=0;
        int day=0;
        while(true){
            if (day>apples.length&&pq.isEmpty()){
                break;
            }
            if (day<apples.length){
                int time=day+days[day];
                pq.add(new int[]{time,apples[day]});
            }
            while(!pq.isEmpty()&&pq.peek()[0]<=day){
                pq.poll();
            }
            if(!pq.isEmpty()){
                res++;
                pq.peek()[1]--;
                if (pq.peek()[1]==0){
                    pq.poll();
                }
            }
            day++;
        }
        return res;
    }
}
