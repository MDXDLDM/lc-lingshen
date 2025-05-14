package edu.scu.myheap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class No630 {
    public int scheduleCourse(int[][] courses) {
//        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[0]-a[0]);
//        for(int[] course:courses){
//            pq.offer(new int[]{course[1]-course[0],course[0]});
//        }
//        int res=0;
//        int current=0;
//        while(!pq.isEmpty()){
//            int[] course=pq.poll();
//            if (current<=course[0]) {
//                current+=course[1];
//                res++;
//                if(!pq.isEmpty()){
//                    if (current>pq.peek()[0]&&pq.peek()[1]<course[1]){
//                        current-=course[1];
//                        res--;
//                    }
//                }
//            }
//        }
//        return res;
        Arrays.sort(courses,(a,b)->(a[1]-b[1]));
        PriorityQueue<Integer> hasvisited=new PriorityQueue<>(Comparator.reverseOrder());
        int res=0;int current=0;
        for(int[] course:courses){
            int cost=course[0];
            int lastday=course[1];
            if(current+cost<=lastday){
                current+=cost;
                res++;
                hasvisited.add(course[0]);
            }else if(!hasvisited.isEmpty()&&hasvisited.peek()>cost){
                current-=hasvisited.poll();
                current+=cost;
                hasvisited.add(course[0]);
            }
        }
        return res;
    }
}
