package edu.scu.part1;

public class No2266 {
    static int[] counts=new int[]{3,3,3,3,3,4,3,4};
    public int countTexts(String pressedKeys) {
        int[] dp=new int[pressedKeys.length()+1];
        dp[0]=1;
        for (int i=0;i<pressedKeys.length();i++){
            char c=pressedKeys.charAt(i);
            int index=1;
            int max=counts[c-'2'];
            while(index<=max&&i-index>=0&&c==pressedKeys.charAt(i-index+1)){
                System.out.println("in"+c+' '+i);
                dp[i+1]+=dp[i-index];
                dp[i+1]%=(1e9+7);
                index++;
            }
        }
        return (int)(dp[pressedKeys.length()]%(1e9+7));
    }
}
