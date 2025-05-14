package edu.scu.myqueue;

import java.util.ArrayDeque;

public class No862 {
    public int shortestSubarray(int[] nums, int k) {
//        int firstindex=0;int lastindex=0;
//        int min=Integer.MAX_VALUE;
//        int temp=0;int pre=0;
//        //boolean flag=false;
//        while(lastindex<nums.length){
//            temp+=nums[lastindex];
//            if (temp<=0){
//                pre=lastindex;
//            }
//            while(temp>=k&&firstindex<=lastindex){
//                while(firstindex<=pre){
//                    temp-=nums[firstindex];
//                    firstindex++;
//                }
//                if (temp>=k){
//                    min=Math.min(min,lastindex-firstindex+1);
//                }
//                if (firstindex<=lastindex){
//                    temp-=nums[firstindex++];
//                }
//                //flag=true;
//            }
////            if(flag){
////                min=Math.min(min,lastindex-firstindex+2);
////            }
////            flag=false;
//            lastindex++;
//        }
//        return min==Integer.MAX_VALUE?-1:min;
        int min = Integer.MAX_VALUE;
        long[] presum = new long[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            presum[i+1] = presum[i]+nums[i];
        }
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i <= nums.length; i++) {
            long temp=presum[i];
            while(!dq.isEmpty() && temp-presum[dq.peek()]>=k) {
                min=Math.min(min,i-dq.poll());
            }
            while(!dq.isEmpty() && presum[dq.peekLast()]>=temp){
                dq.removeLast();
            }
            dq.addLast(i);
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
}
