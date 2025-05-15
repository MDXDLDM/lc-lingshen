package edu.scu.part1;

public class No2606 {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        int[] values=new int[26];
        for (int i=0;i<26;i++){
            values[i]=i+1;
        }
        for (int i = 0; i < chars.length(); i++) {
            values[chars.charAt(i)-'a']=vals[i];
        }
        int[] dp=new int[s.length()+1];
        int max=0;
        for (int i=0;i<s.length();i++){
            int index=s.charAt(i)-'a';
            if (dp[i]>=0){
                dp[i+1]=dp[i]+values[index];
            }else{
                dp[i+1]=Math.max(values[index],0);
            }
            max=Math.max(max,dp[i+1]);
        }
        return max;
    }
}
