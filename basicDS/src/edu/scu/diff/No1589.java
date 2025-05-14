package edu.scu.diff;

import java.util.Arrays;
import java.util.PriorityQueue;

public class No1589 {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        Arrays.sort(nums);
        int[] dec= new int[nums.length+1];
        for (int i = 0; i < requests.length; i++) {
            int start = requests[i][0];
            int end = requests[i][1];
            dec[start]++;
            dec[end+1]--;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        int count=0;
        for (int i = 0; i < nums.length; i++) {
            count+=dec[i];
            pq.add(count);
        }
        long res=0;int temp=0;
        while(!pq.isEmpty()){
            int value=pq.poll();
            //System.out.println(value);
            res+=(long)value*(nums[nums.length-1-temp]);
            temp++;
        }
        return (int)(res%1000000007);
    }
}
