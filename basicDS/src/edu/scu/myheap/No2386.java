package edu.scu.myheap;

import java.util.PriorityQueue;

public class No2386 {
    public long kSum(int[] nums, int k) {
        long res=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int minuscount=0;
        for (int value: nums){
            pq.add(value);
            if (value<=0){
                minuscount++;
            }
        }
        long divide=(long)Math.pow(2,minuscount);//包含全不选的0
        if (k>divide){
            //需要添加正数
            k-=divide;
            while(pq.peek()<=0){
                res+=pq.poll();
            }
            int[] use=getcount(k, pq.size());
        }else{
            int[] use=getcount(k, minuscount);
        }
    }
    private int getC(int n,int m){
        //组合CNM
        int res=1;
        for(int i=1;i<=m;i++){
            res*=n;
            res/=i;
            n--;
        }
        return res;
    }
    private int[] getcount(int total,int count){
        int res=count;
        while(total>1){
            int next=getC(total,res);
            if (total>next){
                total-=next;
                res--;
            }else{
                break;
            }
        }
        return new int[]{res,total};//res代表选取几个数，total代表第几小
    }
}
