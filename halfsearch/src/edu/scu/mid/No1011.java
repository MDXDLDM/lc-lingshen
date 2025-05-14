package edu.scu.mid;

public class No1011 {
    public int shipWithinDays(int[] weights, int days) {
        int sum=0;int min=weights[0];
        for (int i = 0; i < weights.length; i++) {
            sum+=weights[i];
            min=Math.max(min,weights[i]);
        }
        //保证船一定能够单独装下每一个货物
        return getweight(weights,days,sum,min);
    }
    private int getweight(int[] weights, int days,int maxweight,int minweight) {
        int leastweight=minweight;int mostweight=maxweight;
        while(leastweight<=mostweight){
            int mid=leastweight+(mostweight-leastweight>>1);
            int count=0;int tempsum=0;
            for (int i = 0; i < weights.length; i++) {
                tempsum=tempsum+weights[i];
                if(tempsum>mid){
                    tempsum=weights[i];
                    count++;
                }
                if(i==weights.length-1){
                    count++;
                }
            }
            if(count<=days){
                //继续减小weight
                mostweight=mid-1;
            }else{
                leastweight=mid+1;
            }
        }
        return leastweight;
    }
}
