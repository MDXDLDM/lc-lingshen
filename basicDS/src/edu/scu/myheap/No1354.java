package edu.scu.myheap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class No1354 {
    public boolean isPossible(int[] target) {
        if (target.length==1&&target[0]==1)return true;
        long sum=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for (int value :target){
            sum+=value;
            pq.add(value);
        }
        while(!pq.isEmpty()&&pq.peek()>1){
            int max=pq.poll();
            //if (sum==max&&pq.size()>1) return false;
            long temp=sum-max;
            max= (int) (max-(sum-max));
            if (max<1) return false;
            //System.out.println(max);
            pq.add(max);
            sum=temp+max;
        }
        int size=pq.size();
        for(int i=0;i<size;i++){
            //System.out.println(pq.peek());
            if(pq.poll()!=1){
                return false;
            }
        }
        return true;
    }
}
