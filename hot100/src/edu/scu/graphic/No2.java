package edu.scu.graphic;

import java.util.LinkedList;
import java.util.Queue;

public class No2 {
    public int orangesRotting(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        int time=0;
        int oranges=0;
        int badOranges=0;
        Queue<int[]> queue = new LinkedList<int[]>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                    oranges++;badOranges++;
                    visited[i][j] = true;
                }
                if (grid[i][j] == 1) {
                    oranges++;
                }
            }
        }
        if (oranges==badOranges) return 0;
        while (!queue.isEmpty()&&badOranges<oranges) {
            int size = queue.size();
            time++;
            while(size-->0){
                int[] arr = queue.poll();
                for(int[] direction : directions) {
                    int newRow = arr[0] + direction[0];
                    int newCol = arr[1] + direction[1];
                    if (newRow>=0&&newRow<grid.length&&newCol>=0&&newCol<grid[0].length && !visited[newRow][newCol]&&grid[newRow][newCol]==1) {
                        queue.add(new int[]{newRow,newCol});
                        visited[newRow][newCol] = true;
                        grid[newRow][newCol] = 2;
                        badOranges++;
                    }
                }
            }
        }
        return badOranges<oranges?-1:time;
    }
}
