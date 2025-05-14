package edu.scu.myheap;

import java.util.*;

public class No1942 {
    public int smallestChair(int[][] times, int targetFriend) {
        List<int[]> happens = new ArrayList<int[]>();
        for (int i = 0; i < times.length; i++) {
            int come=times[i][0];
            int leave=times[i][1];
            happens.add(new int[]{come,1,i});//排序时come排在后面
            happens.add(new int[]{leave,0,i});
        }
        Collections.sort(happens,new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        });
        PriorityQueue<Integer> chairs=new PriorityQueue<>();
        for (int i=0;i<times.length;i++){
            chairs.offer(i);
        }
        int[] seats=new int[times.length];
        for(int[] happen:happens){
            int time=happen[0];
            int type=happen[1];
            int id=happen[2];
            if (type==0){
                chairs.offer(seats[id]);
            }else{
                seats[id]=chairs.poll();
            }
            if (id==targetFriend){
                return seats[id];
            }
        }
        return -1;
    }
}
