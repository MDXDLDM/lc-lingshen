package edu.scu.string;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class No2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res=new int[nums.length-k+1];
        PriorityQueue<Integer> pq=new PriorityQueue<>(Comparator.reverseOrder());
        //PriorityQueue<Integer> throwOut=new PriorityQueue<>(Comparator.reverseOrder());
        HashMap<Integer,Integer> map=new HashMap<>();
        int firstindex=0;int lastindex=0;
        while(lastindex<k){
            pq.add(nums[lastindex]);
            lastindex++;
        }
        res[firstindex]=pq.peek();
        while(lastindex<nums.length){
            int in=nums[lastindex];
            int out=nums[firstindex];
            map.put(out,map.getOrDefault(out,0)+1);
            if(out==pq.peek()){
                //最大值移出
                //pq.poll();throwOut.poll();
                //延迟删除
                while(!pq.isEmpty()&&!map.isEmpty()&&map.containsKey(pq.peek())){
                    int value=pq.poll();
                    map.put(value,map.getOrDefault(value,0)-1);
                    if(map.get(value)==0){
                        map.remove(value);
                    }
                }
            }
            pq.add(in);
            firstindex++;lastindex++;
            res[firstindex]=pq.peek();
        }
        return res;
    }
}
