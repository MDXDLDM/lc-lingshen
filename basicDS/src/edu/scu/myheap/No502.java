package edu.scu.myheap;

import java.util.PriorityQueue;

public class No502 {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> can=new PriorityQueue<>((a,b)->b[0]-a[0]);
        PriorityQueue<int[]> cannot=new PriorityQueue<>((a,b)->a[1]-b[1]);
        for(int i=0;i<profits.length;i++){
            if (capital[i]>w){
                cannot.add(new int[]{profits[i],capital[i]});
            }else{
                can.add(new int[]{profits[i],capital[i]});
            }
        }
        while(k-->0){
            if (can.isEmpty()){
                break;
            }
            w+=can.poll()[0];
            while(!cannot.isEmpty()&&w>=cannot.peek()[1]){
                can.add(new int[]{cannot.peek()[0],cannot.poll()[1]});
            }
        }
        return w;
    }
}
