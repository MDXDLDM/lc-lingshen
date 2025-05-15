package edu.scu.part1;

public class No1191 {
    public int kConcatenationMaxSum(int[] arr, int k) {
        long[] dp=new long[arr.length];
        long sum=0;
        for(int num:arr){
            sum+=num;
        }
        long maxx=0;
        if(sum>0&&k>=2){
            maxx+=sum*(k-2);
            k=2;
        }else if (k>=2){
            k=2;
        }
        long max=0;
        while(k>0){
            for(int i=0;i<arr.length;i++){
                int index=i==0?arr.length-1:i-1;
                if (dp[index]<0){
                    dp[i]=Math.max(0,arr[i]);
                }else{
                    dp[i]=arr[i]+dp[index];
                }
                //dp[i]%=1000000007;
                max=Math.max(max,dp[i]);
            }
            k--;
        }
        return (int)((max+maxx)%1000000007);
    }
}
