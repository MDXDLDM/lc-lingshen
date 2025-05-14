package edu.scu.myenum;

public class No2905 {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        if(indexDifference==0&&valueDifference==0){
            return new int[]{0,0};
        }
        if(indexDifference>nums.length-1){
            return new int[]{-1,-1};
        }
        int minvalue=nums[0];
        int maxvalue=nums[0];
        int tempminindex=0;int tempmaxindex=0;
        //同时维护最大最小来保证abs
        for (int i = indexDifference; i < nums.length; i++) {
            if(nums[i-indexDifference]<minvalue){
                tempminindex=i-indexDifference;
                minvalue=nums[i-indexDifference];
            }
            if(nums[i-indexDifference]>maxvalue){
                tempmaxindex=i-indexDifference;
                maxvalue=nums[i-indexDifference];
            }
            if(nums[i]>=minvalue+valueDifference){
                return new int[]{tempminindex,i};
            }
            if(nums[i]<=maxvalue-valueDifference){
                return new int[]{tempmaxindex,i};
            }
        }
        return new int[]{-1,-1};
    }
}
