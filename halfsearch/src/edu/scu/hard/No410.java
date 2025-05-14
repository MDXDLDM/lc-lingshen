package edu.scu.hard;

public class No410 {
    public int splitArray(int[] nums, int k) {
        int max=0;
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            max=Math.max(max,nums[i]);
        }
        int left=max;int right=sum;
        while(left<=right){
            int mid=left+(right-left>>1);
            if(check(nums,k,mid)){
                //代表此时分块还有剩余，可以进一步减小
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
    private boolean check(int[] nums, int k,int top) {
        int temp=0;
        for (int i = 0; i < nums.length; i++) {
            temp+=nums[i];
            if(temp>top){
                temp=nums[i];
                k--;
            }
            if(i==nums.length-1){
                k--;
            }
        }
        return k>=0;
    }
}
