package edu.scu.mid;

public class No1760 {
    public int minimumSize(int[] nums, int maxOperations) {
        int max=0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int left=1;int right=max;
        while(left<=right){
            int mid=left+(right-left>>1);
            if(check(nums,maxOperations,mid)){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
    private boolean check(int[] nums, int maxOperations, int top) {
        for (int i = 0; i < nums.length; i++) {
            maxOperations-=(nums[i]-1)/top;
        }
        return maxOperations>=0;
    }
}
