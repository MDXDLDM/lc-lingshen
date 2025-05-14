package edu.scu.mid;

import java.util.PriorityQueue;

public class No1642 {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int[] need=new int[heights.length];
        for (int i = 1; i < heights.length; i++) {
            need[i]=heights[i]-heights[i-1];
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        int index=0;
        while(index<heights.length){
            if(need[index]<=0){
                index++;
                continue;
            }
            bricks-=need[index];
            pq.offer(need[index]);
            if(bricks<0){
                if(ladders<=0){
                    return index-1;
                }else{
                    ladders--;
                    bricks+=pq.poll();
                }
            }
            index++;
        }
        return heights.length-1;
    }
}
