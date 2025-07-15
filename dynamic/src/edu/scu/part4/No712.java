package edu.scu.part4;

public class No712 {
    public int minimumDeleteSum(String s1, String s2) {
        int len1=s1.length();
        int len2=s2.length();
        int total=0;
        int[] dp=new int[len2+1];
        for(int i=0;i<len1;i++){
            char a=s1.charAt(i);
            total+=a;
            for(int j=len2;j>=1;j--){
                char b=s2.charAt(j-1);
                if(a==b){
                    dp[j]=Math.max(dp[j],dp[j-1]+a);
                }
            }
            for(int j=1;j<=len2;j++){
                char b=s2.charAt(j-1);
                if(a!=b){
                    dp[j]=Math.max(dp[j-1],dp[j]);
                }
            }
        }
        for(int i=0;i<len2;i++){
            total+=s2.charAt(i);
        }
        //System.out.println(total+" "+dp[len2]);
        return total-dp[len2]*2;
    }
}
