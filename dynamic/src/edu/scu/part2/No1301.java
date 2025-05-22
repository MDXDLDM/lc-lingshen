package edu.scu.part2;

import java.util.List;

public class No1301 {
    public int[] pathsWithMaxScore(List<String> board) {
        int[][][] dp=new int[board.size()+1][board.size()+1][2];
        String[] arr=board.toArray(new String[board.size()]);
        dp[arr.length][arr.length][1]=1;
        for (int i=arr.length-1;i>=0;i--){
            for (int j=arr[i].length()-1;j>=0;j--){
                char c=arr[i].charAt(j);
                if (c=='X'){
                    continue;
                }
                int max=0;
                if (dp[i+1][j][0]>=max){
                    max=dp[i+1][j][0];
                    dp[i][j][1]=dp[i+1][j][1];
                }
                if (dp[i][j+1][0]>=max){
                    if (dp[i][j+1][0]==max){
                        dp[i][j][1]+=dp[i][j+1][1];
                    }else{
                        dp[i][j][1]=dp[i][j+1][1];
                    }
                    max=dp[i][j+1][0];
                }
                if(dp[i+1][j+1][0]>=max){
                    if (dp[i+1][j+1][0]==max){
                        dp[i][j][1]+=dp[i+1][j+1][1];
                    }else{
                        dp[i][j][1]=dp[i+1][j+1][1];
                    }max=dp[i+1][j+1][0];
                }
                if (max==0&&dp[i][j][1]==0){
                    continue;
                }
                if (c=='E'||c=='S'){
                    dp[i][j][0]=max;
                }else{
                    dp[i][j][0]=max+c-'0';
                }
                dp[i][j][1]%=1000000007;
                System.out.println(dp[i][j][0]+" "+dp[i][j][1]);
            }
        }
        return new int[]{dp[0][0][0],dp[0][0][1]};
    }
}
