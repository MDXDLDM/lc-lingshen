package edu.scu.part2;

import java.util.LinkedList;
import java.util.Queue;

public class No329 {
    static int[][] pos=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public int longestIncreasingPath(int[][] matrix) {
//        int[][] dp=new int[matrix.length+1][matrix[0].length+1];
//        int[][] dp2=new int[matrix.length+1][matrix[0].length+1];
//        int max=0;
//        for (int i=0;i<matrix.length;i++){
//            for (int j=0;j<matrix[0].length;j++){
//                int value=matrix[i][j];
//                if (i>0&&value>matrix[i-1][j]){
//                    dp[i+1][j+1]=Math.max(dp[i][j+1],dp[i+1][j+1]);
//                }
//                if (j>0&&value>matrix[i][j-1]){
//                    dp[i+1][j+1]=Math.max(dp[i+1][j],dp[i+1][j+1]);
//                }
//                dp[i+1][j+1]++;
//            }
//        }
//        //
////        for (int i=0;i<matrix.length;i++){
////            for (int j=0;j<matrix[0].length;j++){
////                int value=matrix[i][j];
////                if (i>0&&value<matrix[i-1][j]){
////                    dp2[i+1][j+1]=Math.max(dp2[i][j+1],dp2[i+1][j+1]);
////                }
////                if (j>0&&value<matrix[i][j-1]){
////                    dp2[i+1][j+1]=Math.max(dp2[i+1][j],dp2[i+1][j+1]);
////                }
////                dp2[i+1][j+1]++;
////            }
////        }
////        for (int i=0;i<matrix.length;i++){
////            for (int j=0;j<matrix[0].length;j++){
////                max=Math.max(max,dp[i+1][j+1]+dp2[i+1][j+1]-1);
////            }
////        }
//        for(int i=matrix.length-1;i>=0;i--){
//            for (int j=matrix[0].length-1;j>=0;j--){
//                int value=matrix[i][j];
//                int temp=0;
//                if(i<matrix.length-1&&value>matrix[i+1][j]){
//                    temp=Math.max(temp,dp[i+2][j+1]);
//                }
//                if (j<matrix[0].length-1&&value>matrix[i][j+1]){
//                    temp=Math.max(temp,dp[i+1][j+2]);
//                }
//                max=Math.max(max,temp+dp[i+1][j+1]);
//                dp[i+1][j+1]=temp+1;
//            }
//        }
//        return max;
        int[][] dp=new int[matrix.length][matrix[0].length];
        //出度数组
        Queue<int[]> q=new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int value=matrix[i][j];
                if (i>0&&value<matrix[i-1][j]) {
                    dp[i][j]++;
                }
                if (i<matrix.length-1&&value<matrix[i+1][j]) {
                    dp[i][j]++;
                }
                if (j>0&&value<matrix[i][j-1]) {
                    dp[i][j]++;
                }
                if (j<matrix[0].length-1&&value<matrix[i][j+1]) {
                    dp[i][j]++;
                }
            }
        }
        //从出度为0的地方开始从尾部拼接
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if(dp[i][j]==0){
                    q.add(new int[]{i,j});
                }
            }
        }
        int res=0;
        while (!q.isEmpty()) {
            //拼接尾部到新的一层
            res++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] arr=q.poll();
                int row=arr[0];int col=arr[1];
                for (int j=0;j<4;j++) {
                    int newrow=row+pos[j][0];
                    int newcol=col+pos[j][1];
                    if (newrow>=0&&newcol>=0&&newrow<matrix.length&&newcol<matrix[0].length&&matrix[newrow][newcol]<matrix[row][col]) {
                        dp[newrow][newcol]--;
                        //代表此处的出度已经计算完毕，避免重复添加
                        if (dp[newrow][newcol]==0) {
                            q.offer(new int[]{newrow,newcol});
                        }
                    }

                }
            }
        }
        return res;
    }
}
