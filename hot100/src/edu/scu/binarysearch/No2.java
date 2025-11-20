package edu.scu.binarysearch;

public class No2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        return binarySearch(matrix,target);
    }
    private boolean binarySearch(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0;
        int right = row*col - 1;
        while (left <= right) {
            int mid=left + (right - left>>1);
            int midRow = mid / col;
            int midCol = mid % col;
            if (matrix[midRow][midCol] == target) {
                return true;
            }else if(matrix[midRow][midCol] < target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return false;
    }
}
