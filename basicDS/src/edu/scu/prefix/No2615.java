package edu.scu.prefix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class No2615 {
    public long[] distance(int[] nums) {
        long[] res = new long[nums.length];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<Integer>());
            }
            map.get(nums[i]).add(i);
        }
        for(List<Integer> list : map.values()) {
            long[] tempsum=new long[list.size()];
            long sum=0;
            for(int i=0;i<list.size();i++) {
                tempsum[i]=sum;
                sum+=list.get(i);
            }
            for (int i = 0; i < list.size(); i++) {
                long left=(long)list.get(i)*i-tempsum[i];
                long right=sum-tempsum[i]-(long)list.get(i)*(list.size()-i-1);
                //System.out.println(left+" "+right);
                res[list.get(i)]=left+right;
            }
        }
        return res;
    }
}
