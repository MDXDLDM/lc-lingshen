package edu.scu.myheap;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class LCP30 {
    public int magicTower(int[] nums) {
        PriorityQueue<Integer> hasvisited=new PriorityQueue<>();
        long sum=0;
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            queue.add(nums[i]);
        }
        if (sum<=0) return -1;
        int res=0;long current=1;
        while(!queue.isEmpty()){
            int thiscurrent=queue.poll();
            if (thiscurrent<0){
                hasvisited.add(thiscurrent);
            }
            current+=thiscurrent;
            while(current<=0){
                //System.out.println("add");
                if (!hasvisited.isEmpty()) {
                    res++;
                    int out=hasvisited.poll();
                    current-=out;
                    queue.add(out);
                }
            }
        }
        return res;
    }
}
