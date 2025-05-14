package edu.scu.myheap;

import java.util.Collections;
import java.util.PriorityQueue;

public class No871 {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> hasvisited=new PriorityQueue<>(Collections.reverseOrder());
        int current=startFuel;
        int index=0;int res=0;
        while(current<target){
            while(index<stations.length&&stations[index][0]<=current){
                hasvisited.add(stations[index][1]);
                index++;
            }
            if (!hasvisited.isEmpty()){
                current+=hasvisited.poll();
                res++;
            }else{
                return -1;
            }
        }
        return res;
    }
}
