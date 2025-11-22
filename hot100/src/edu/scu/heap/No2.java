package edu.scu.heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class No2 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>((a, b)->(map.get(a)-map.get(b)));
        for(Integer key:map.keySet()){
            if(pq.size()<k){
                pq.add(key);
            }else{
                if(map.get(key)>map.get(pq.peek())){
                    pq.poll();
                    pq.add(key);
                }
            }
        }
        int[] res=new int[k];
        int index=0;
        while(!pq.isEmpty()){
            res[index++]=pq.poll();
        }
        return res;
    }
}
