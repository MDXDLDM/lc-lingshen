package edu.scu.part4;

public class No1458 {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int len1=nums1.length;
        int len2=nums2.length;
        int[][] dp=new int[len1+1][len2+1];
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                int chooseThis=nums1[i]*nums2[j];
                dp[i][j]=Math.max(Math.max(dp[i-1][j-1]+chooseThis,chooseThis),Math.max(dp[i-1][j],dp[i][j-1]));
            }
        }
        return dp[len1][len2];
    }
}
