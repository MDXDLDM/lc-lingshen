package edu.scu.mid;

import java.util.LinkedList;
import java.util.Queue;

public class No1631 {
    private static int[][] pos={{0,1},{-1,0},{0,-1},{1,0}};
    public int minimumEffortPath(int[][] heights) {
        int max=0;
        for (int i = 0; i < heights.length; i++) {
            for (int i1 = 0; i1 < heights[i].length; i1++) {
                max=Math.max(max, heights[i][i1]);
            }
        }
        int left=0;int right=max;
        while(left<=right){
            int mid=left+(right-left>>1);
            if(check(heights,mid)){
                //mid可以进一步减小
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
    private boolean check(int[][] heights, int top){
        int[][] flag=new int[heights.length][heights[0].length];
        Queue<Integer> queue=new LinkedList<>();
        queue.add(0);queue.add(0);
        flag[0][0]=1;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<(size>>1);i++){
                int x=queue.poll();
                int y=queue.poll();
                for(int j=0;j<4;j++){
                    int newx=x+pos[j][0];
                    int newy=y+pos[j][1];
                    if(newx<0||newx>=heights[0].length||newy<0||newy>=heights.length||flag[newx][newy]==1||Math.abs(heights[newx][newy]-heights[x][y])>top){
                        continue;
                    }
                    flag[newx][newy]=1;
                    queue.add(newx);queue.add(newy);
                }
            }
        }
        return flag[heights.length-1][heights[0].length-1]==1;
    }
}
