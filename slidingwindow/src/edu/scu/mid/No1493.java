package edu.scu.mid;

public class No1493 {
    public int longestSubarray(int[] nums) {
        int before=0;int current=0;int max=0;
        int startindex=0;
        while(startindex<nums.length){
//            if(nums[startindex]==0){
//                startindex++;
//                continue;
//            }
//            只允许删除一个，此时不做跳过处理表示有两个连续0，正好可以使before和current都变为0
            while(startindex<nums.length&&nums[startindex]==1){
                current++;
                startindex++;
            }
            max=Math.max(max,current+before);
            before=current;
            current=0;
            startindex++;
        }
        return max==nums.length?max-1:max;
    }
}
