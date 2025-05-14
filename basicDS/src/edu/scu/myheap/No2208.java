package edu.scu.myheap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class No2208 {
    public int halveArray(int[] nums) {
        int res=0;
        double sum=0;
        PriorityQueue<Double> pq=new PriorityQueue<>((p,q)->Double.compare(q,p));
        for (int value:nums){
            pq.add((double)value);
            sum+=value;
        }
        double temp=0;
        while(temp*2<sum){
            double num=pq.poll();
            temp+=num/2;
            pq.add(num/2);
            res++;
        }
        return res;
    }
}
