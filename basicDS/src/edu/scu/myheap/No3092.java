package edu.scu.myheap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class No3092 {
    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        HashMap<Integer,Long> map = new HashMap<>();
        PriorityQueue<long[]> pq=new PriorityQueue<>((p,q)->Long.compare(q[1],p[1]));
        long[] result=new long[nums.length];
        for (int i=0;i<nums.length;i++){
            int value=nums[i];
            int change=freq[i];
            if(!map.containsKey(value)){
                map.put(value,0L);
            }
            map.put(value,map.get(value)+change);
            pq.add(new long[]{value,map.get(value)});
            while(!pq.isEmpty()&&pq.peek()[1]>map.get((int)pq.peek()[0])){
                pq.poll();
            }
            result[i]=pq.peek()[1];
        }
        return result;

    }
}
