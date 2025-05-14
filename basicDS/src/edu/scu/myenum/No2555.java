package edu.scu.myenum;

public class No2555 {
    public int maximizeWin(int[] prizePositions, int k) {
        int leftmax=0;
        int res=0;
        for(int i=0;i<prizePositions.length;i++){
            int leftindex=find(prizePositions,prizePositions[i]-k);
            int rightindex=find(prizePositions,prizePositions[i]+k+1);
            res=Math.max(res,rightindex-i+leftmax);
            leftmax=Math.max(leftmax,i-leftindex+1);
        }
        return res==0? prizePositions.length : res;
    }
    private int find(int[] nums,int value){
        int left=0;int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left>>1);
            if(nums[mid]<value){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return left;//第一个位置
    }
}
