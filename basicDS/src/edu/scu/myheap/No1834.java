package edu.scu.myheap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class No1834 {
    public int[] getOrder(int[][] tasks) {
        int[] res = new int[tasks.length];
        //就绪队列
        PriorityQueue<int[]> pq=new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1]==o2[1]){
                    return o1[2]-o2[2];
                }
                return o1[1]-o2[1];
            }
        });
        PriorityQueue<int[]> newarray=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]!=o2[0]) return o1[0]-o2[0];
                if (o1[1]!=o2[1]) return o1[1]-o2[1];
                return o1[2]-o2[2];
            }
        });
        for (int i = 0; i < tasks.length; i++) {
            newarray.add(new int[]{tasks[i][0], tasks[i][1],i});
        }
        int timenow=1;//boolean flag=false;
        int index=0;
        while (!newarray.isEmpty()){
             //将所有arrive作业加入就绪队列
            while(!newarray.isEmpty()&&newarray.peek()[0]<=timenow){
                pq.add(newarray.poll());
            }
            if (pq.isEmpty()){
                timenow=newarray.peek()[0]+newarray.peek()[1];
            }
            if (!pq.isEmpty()){
                //执行任务
                res[index++]=pq.peek()[2];
                //此任务执行完成
                timenow=Math.max(pq.peek()[0]+pq.peek()[1],timenow+pq.poll()[1]);
                System.out.println(timenow);
            }
        }
        while(!pq.isEmpty()){
            res[index++]=pq.poll()[2];
        }
        return res;
    }
}
