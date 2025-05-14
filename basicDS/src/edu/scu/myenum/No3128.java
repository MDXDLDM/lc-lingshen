package edu.scu.myenum;

public class No3128 {
    public long numberOfRightTriangles(int[][] grid) {
        long sum=0;
        int[] rows=new int[grid.length];
        int[] cols=new int[grid[0].length];
        for(int i=0;i<rows.length;i++){
            for(int j=0;j<cols.length;j++){
                rows[i]+=grid[i][j]==1?1:0;
            }
        }
        for(int i=0;i<cols.length;i++){
            for(int j=0;j<rows.length;j++){
                cols[i]+=grid[j][i]==1?1:0;
            }
        }
        for(int i=0;i<rows.length;i++){
            for(int j=0;j<cols.length;j++){
                if(grid[i][j]==1){
                    sum+=(long)(rows[i]-1)*(cols[j]-1);
                }
            }
        }
        return sum;
    }
}
