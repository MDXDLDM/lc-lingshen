package edu.scu.mid;

public class No2064 {
    public int minimizedMaximum(int n, int[] quantities) {
        int max=0;
        for (int i = 0; i < quantities.length; i++) {
            max = Math.max(max, quantities[i]);
        }
        int left=1;int right=max;
        while(left<=right){
            int mid=left+(right-left>>1);
            if(check(n,mid,quantities)){
                //表示此时n仍然不为负，可以继续减小
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
    private boolean check(int n,int top,int[] quantities){
        for (int i = 0; i < quantities.length; i++) {
            n-=(quantities[i]-1)/top+1;
        }
        return n>=0;
    }
}
