package edu.scu.myheap;

import java.util.PriorityQueue;

public class No264 {
    public int nthUglyNumber(int n) {
//        int left=1;int right=n*2;
//        while(left<=right){
//            int mid=left+(right-left)/2;
//            if(check(mid)>=n){
//                right=mid-1;
//            }else{
//                left=mid+1;
//            }
//        }
//        return left;
//        PriorityQueue<Long> pq = new PriorityQueue<>();
//        pq.add(1L);
//        int index=1;
//        while(!pq.isEmpty()) {
//            long base = pq.poll();
//            if (index==n){
//                return (int)base;
//            }
//            if (!pq.contains(base * 2)) {
//                pq.add(base * 2);
//            }
//            if (!pq.contains(base * 3)) {
//                pq.add(base * 3);
//            }
//            if (!pq.contains(base * 5)) {
//                pq.add(base * 5);
//            }
//            index++;
//        }
//        return -1;
        //dp
        int[] dp=new int[n];
        dp[0]=1;
        int plus2index=0;int plus3index=0;int plus5index=0;//表示当前乘数进行到第几个数了
        for (int i=1;i<n;i++){
            int num2=dp[plus2index]*2;int num3=dp[plus3index]*3;int num5=dp[plus5index]*5;
            dp[i]=Math.min(num2,Math.min(num3,num5));
            if (dp[i]==num2){
                plus2index++;
            }
            if (dp[i]==num3){
                plus3index++;
            }
            if (dp[i]==num5){
                plus5index++;
            }
            //三个if并列执行去重
        }
        return dp[n-1];
    }
    private int check(int n){
        return n/2+n/3+n/5+1-n/6-n/10-n/15+n/30;
    }
}
