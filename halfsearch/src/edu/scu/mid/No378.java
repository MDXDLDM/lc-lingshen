package edu.scu.mid;

public class No378 {
    public int kthSmallest(int[][] matrix, int k) {
        int left=matrix[0][0];int right=matrix[matrix.length-1][matrix[0].length-1];
        while(left<=right) {
            int mid=left+(right-left>>1);
            int temp=0;
            for(int i=0;i<matrix.length;i++) {
                temp+=check(matrix[i],mid);
            }
            if(temp>k){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return right;
    }
    //check 返回的是数组中小于等于num的个数
    private int check(int[] nums, int num) {
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left>>1);
            if(nums[mid]<=num){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return left;
    }
}
