package edu.scu.matrix;

public class No4 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int min=matrix[0][0];
        int max=matrix[matrix.length-1][matrix[0].length-1];
        if(target<min || target>max) return false;
//        for(int i=0;i<matrix[0].length;i++){
//            int goalrow=Math.min(matrix[0].length-1-i,matrix.length-1);
//            int goalcol=Math.min(matrix.length-1+i,matrix[0].length-1);
//            if(search(matrix,target,0,i,goalrow,goalcol)){
//                return true;
//            }
//        }
//        for(int i=1;i<matrix.length;i++){
//            int goalrow=Math.min(matrix[0].length-1+i,matrix.length-1);
//            int goalcol=Math.min(matrix.length-1-i,matrix[0].length-1);
//            if(search(matrix,target,i,0,goalrow,goalcol)){
//                return true;
//            }
//        }
//        return false;
        int currentrow=0;int currentcol=matrix[0].length-1;
        while(currentrow>=0&&currentcol>=0&&currentrow<matrix.length&&currentcol<matrix[0].length){
            if(matrix[currentrow][currentcol]==target){
                return true;
            }else if(matrix[currentrow][currentcol]<target){
                currentrow++;
            }else{
                currentcol--;
            }
        }
        return false;
    }
    private boolean search(int[][] matrix, int target,int leftrow,int leftcol,int rightrow,int rightcol){
        while(leftrow<=rightrow&&leftcol<=rightcol){
            int midrow=(leftrow+rightrow)/2;
            int midcol=(leftcol+rightcol)/2;
            if(matrix[midrow][midcol]==target){
                return true;
            }else if(matrix[midrow][midcol]<target){
                leftrow=midrow+1;
                leftcol=midcol+1;
            }else{
                rightrow=midrow-1;
                rightcol=midcol-1;
            }
        }
        return false;
    }
}
