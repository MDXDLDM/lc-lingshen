package edu.scu.myqueue;

import java.util.PriorityQueue;

public class No2762 {
    public long continuousSubarrays(int[] nums) {
        PriorityQueue<Integer> max=new PriorityQueue<>((p,q)->q-p);
        PriorityQueue<Integer> min=new PriorityQueue<>();
        int lastindex=0;
        int firstindex=0;
        long res=0;
        while(lastindex<nums.length){
            max.add(nums[lastindex]);
            min.add(nums[lastindex]);
            if (max.peek()-min.peek()>2) {
                long temp=lastindex-firstindex;
                res+=(temp+1)*temp/2;
                while(max.peek()-min.peek()>2){
                    int value=nums[firstindex];
                    max.remove(value);
                    min.remove(value);
                    firstindex++;
                }
                //减去重复的
                temp=lastindex-firstindex;
                res-=(temp+1)*temp/2;
            }
            lastindex++;
            //System.out.println(res);
        }
        long temp=lastindex-firstindex;
        res+=(temp+1)*temp/2;
        //res+= nums.length;
        return res;
    }
}
