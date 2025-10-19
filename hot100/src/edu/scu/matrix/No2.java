package edu.scu.matrix;

import java.util.ArrayList;
import java.util.List;

public class No2 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        int round=0;
        while(round<=rows-round-1&&round<=cols-round-1){
            addElement(list,matrix,round,round,cols-round-1,rows-round-1);
            round++;
        }
        return list;
    }
    private void addElement(List<Integer> list,int[][] matrix, int startX,int startY,int endX,int endY){
        for(int i=startX; i<=endX; i++){
            list.add(matrix[startY][i]);
        }
        if(startY==endY) return;
        for(int i=startY+1; i<=endY; i++){
            list.add(matrix[i][endX]);
        }
        if(startX==endX) return;
        for(int i=endX-1; i>=startX; i--){
            list.add(matrix[endY][i]);
        }
        for(int i=endY-1; i>startY; i--){
            list.add(matrix[i][startX]);
        }
    }
}
