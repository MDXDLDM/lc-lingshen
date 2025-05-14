package edu.scu.myheap;

import java.util.PriorityQueue;

public class No3275 {
    public int[] resultsArray(int[][] queries, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((p,q)->(q - p));
        int[] res=new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int value=Math.abs(queries[i][0])+Math.abs(queries[i][1]);
            pq.add(value);
            if (pq.size()>k){
                pq.poll();
            }
            if (i+1<k){
                res[i]=-1;
            }else{
                res[i]=pq.peek();
            }
        }
        return res;
    }
}
