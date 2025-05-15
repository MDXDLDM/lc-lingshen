package edu.scu.part1;

public class No2140 {
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length+1];
        for (int i=questions.length-1; i>=0; i--) {
            int value=questions[i][0];
            int count=questions[i][1]+i+1;
            if (count< questions.length){
                dp[i]=Math.max(dp[count]+value,dp[i+1]);
            }else{
                dp[i]=Math.max(dp[i+1],value);
            }
        }
        return dp[0];
    }
}
