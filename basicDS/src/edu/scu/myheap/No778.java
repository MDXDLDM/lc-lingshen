package edu.scu.myheap;

import java.util.LinkedList;
import java.util.Queue;

public class No778 {
    private static int[][] map;
    private static int[][] dirs=new int[][]{{1,0},{0,-1},{-1,0},{0,1}};
    public int swimInWater(int[][] grid) {
        map=grid;
        int left=0;int right=grid.length * grid.length-1;
        if (right==0) return 0;
        while(left<=right){
            int mid=left+(right-left>>1);
            if (check(mid)){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
    private boolean check(int mid){
        //int x=0;int y=0;
        int[][] visited=new int[map.length][map[0].length];
        Queue<int[]> q=new LinkedList<>();
        if (map[0][0]>mid) return false;
        q.add(new int[]{0,0});
        visited[0][0]=1;
        while(!q.isEmpty()){
            int[] arr=q.poll();
            int x=arr[0];int y=arr[1];
            for(int i=0;i<4;i++){
                int x1=x+dirs[i][0];
                int y1=y+dirs[i][1];
                if (x1>=0&&x1<map.length&&y1>=0&&y1<map[0].length){
                    if (map[x1][y1]<=mid&&visited[x1][y1]==0){
                        //System.out.println("add");
                        if (x1==map.length-1&&y1==map[0].length-1){
                            return true;
                        }
                        q.add(new int[]{x1,y1});
                        visited[x1][y1]=1;
                    }
                }
            }
        }
        System.out.println(false);
        return false;
    }
}
