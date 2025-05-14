package edu.scu.myheap;

import java.util.PriorityQueue;

public class No2462 {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> first=new PriorityQueue<>();
        PriorityQueue<Integer> last=new PriorityQueue<>();
        for (int i=0;i<costs.length;i++){
            if (i<candidates){
                first.add(costs[i]);
            }
            if (i>=costs.length-candidates&&i>=candidates){
                last.add(costs[i]);
            }
        }
        long res=0;
        int firstindex=candidates;int lastindex=costs.length-candidates-1;
        while(k-->0){
            int flag=0;//lastpoll-1 firstpoll-2
            if (first.isEmpty()){
                flag=1;
            }else if (last.isEmpty()){
                flag=2;
            }else{
                int a=first.peek();
                int b=last.peek();
                if (a>b){
                    flag=1;
                }else{
                    flag=2;
                }
            }
            if (flag==1){
                res+=last.poll();
                if (lastindex>=firstindex){
                    last.add(costs[lastindex--]);
                }
            }else{
                res+=first.poll();
                if (firstindex<=lastindex){
                    first.add(costs[firstindex++]);
                }
            }
        }
        return res;
    }
}
