package edu.scu.diff;

public class No2536 {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] dec=new int[n+1][n+1];
        for (int i = 0; i < queries.length; i++) {
            int startx=queries[i][0];
            int starty=queries[i][1];
            int endx=queries[i][2];
            int endy=queries[i][3];
            for (int j = startx; j <= endx; j++) {
                dec[j][starty]++;
                dec[j][endy+1]--;
            }

        }
        int[][] ans=new int[n][n];
        int temp=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp+=dec[i][j];
                ans[i][j]=temp;
            }
            temp+=dec[i][n];
        }
        return ans;
    }
}
