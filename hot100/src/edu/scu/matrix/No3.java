package edu.scu.matrix;

public class No3 {
    public void rotate(int[][] matrix) {
//        int n = matrix.length;
//        for (int i = 0; i < n/2; i++) {
//            move(matrix,i);
//        }
        //只需确保行翻转时已经都转置完即可
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            int[] row = matrix[i];
            for (int j = i + 1; j < n; j++) { // 遍历对角线上方元素，做转置
                int temp = row[j];
                row[j] = matrix[j][i];
                matrix[j][i] = temp;
            }
            for (int j = 0; j < n / 2; j++) { // 遍历左半元素，做行翻转
                int temp = row[j];
                row[j] = row[n - 1 - j];
                row[n - 1 - j] = temp;
            }
        }
    }
    private void move(int[][] matrix,int round) {
        int n = matrix.length-1;
        //先交换四角
        swap(matrix,round,round,round,n-round);
        swap(matrix,round,round,n-round,n-round);
        swap(matrix,round,round,round,n-round);
        //交换剩余
        for(int i=round+1;i<n-round;i++){
            swap(matrix,round,i,i,n-round);
        }
        for(int i=round+1;i<n-round;i++){
            swap(matrix,round,i,n-round,n-i);
        }
        for(int i=round+1;i<n-round;i++){
            swap(matrix,round,i,n-i,round);
        }
    }
    private void swap(int[][] matrix, int row1, int col1, int row2, int col2) {
        int temp = matrix[row1][col1];
        matrix[row1][col1] = matrix[row2][col2];
        matrix[row2][col2] = temp;
    }
}
