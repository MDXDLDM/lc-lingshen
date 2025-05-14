package edu.scu.mid;

public class No2439 {
    public int minimizeArrayValue(int[] nums) {
        int max=0;
        for (int i = 0; i < nums.length; i++) {
            max=Math.max(max,nums[i]);
        }
        int left=0;int right=max;
        while(left<=right) {
            int mid=left+(right-left>>1);
            if(check(nums,mid)){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
    private boolean check(int[] nums,int top){
        long temp=0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i]>top) {
                temp+=nums[i]-top;
            }else{
                temp=Math.max(0,temp-(top-nums[i]));
            }
        }
        return temp==0;
    }
}
