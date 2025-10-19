package edu.scu.matrix;

import java.util.Arrays;

public class No1 {
    public void setZeroes(int[][] matrix) {
//        int[] rowzeros = new int[matrix.length];
//        int[] colzeros = new int[matrix[0].length];
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                if (matrix[i][j] == 0) {
//                    rowzeros[i] = 1;
//                    colzeros[j] = 1;
//                }
//            }
//        }
//        for (int i = 0; i < matrix.length; i++) {
//            if(rowzeros[i]==1){
//                Arrays.fill(matrix[i],0);
//            }
//        }
//        for (int i = 0; i < matrix[0].length; i++) {
//            if(colzeros[i]==1){
//                for (int j = 0; j < matrix.length; j++) {
//                    matrix[j][i] = 0;
//                }
//            }
//        }
        //O1空间
        boolean colflag=false;
        boolean rowflag=false;
        boolean flag=matrix[0][0]==0;
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][0] == 0){
                colflag=true;
                break;
            }
        }
        for(int i = 0; i < matrix[0].length; i++){
            if(matrix[0][i] == 0){
                rowflag=true;
                break;
            }
        }
        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[i].length; j++){
                if(matrix[i][j]==0){
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }
        for(int i=1;i<matrix.length;i++){
            if(matrix[i][0]==0){
                Arrays.fill(matrix[i],0);
            }
        }
        for(int i=1;i<matrix[0].length;i++){
            if(matrix[0][i]==0){
                for(int j=1;j<matrix.length;j++){
                    matrix[j][i]=0;
                }
            }
        }
        if (flag||colflag){
            for(int i=0;i<matrix.length;i++){
                matrix[i][0]=0;
            }
        }
        if(flag||rowflag){
            Arrays.fill(matrix[0],0);
        }
    }
}
