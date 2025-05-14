package edu.scu.myenum;

import java.util.HashMap;

public class No2342 {
    public int maximumSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max=-1;
        for (int i = nums.length - 1; i >= 0; i--) {
            int temp=getnumsum(nums[i]);
            if(map.containsKey(temp)) {
                max=Math.max(max,map.get(temp)+nums[i]);
                map.put(temp, Math.max(map.get(temp), nums[i]));
            }else{
                map.put(temp,nums[i]);
            }
        }
        return max;
    }
    private int getnumsum(int num) {
        int sum = 0;
        while(num!=0){
            sum += num%10;
            num/=10;
        }
        return sum;
    }
}
