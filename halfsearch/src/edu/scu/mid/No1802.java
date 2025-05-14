package edu.scu.mid;

public class No1802 {
    public int maxValue(int n, int index, int maxSum) {
        int left=1;
        int right=Math.max(n-index,index+1);
        right=Math.max(right,maxSum-n+1);
        while(left<=right){
            int mid=left+(right-left>>1);
            long sum=getsum(n,index,mid);
            if(sum>maxSum){
                //说明大了
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return right;
    }
    private long getsum(int n,int index,int value){
        long sum=0;
        if(value>=index+1){
            sum+= (long) (value - index + value) *(index+1)/2;
        }else{
            sum+= (long) (value+1) * (value)/2;
            sum+= (long) index-value+1;
        }
        if(value>=n-index){
            sum+= (long) (value-(n-index)+1+value) *(n-index)/2;
        }else{
            sum+= (long) (value+1) * (value)/2;
            sum+= (long) n-value-index;
        }
        return sum-value;
    }
}
