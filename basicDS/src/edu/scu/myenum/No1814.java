package edu.scu.myenum;

import java.util.*;

public class No1814 {
    public int countNicePairs(int[] nums) {
        //int[] func = new int[nums.length];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int rev=getreverse(nums[i]);
            //func[i]=nums[i]-rev;
            int temp=nums[i]-rev;
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        long count=0;
        for(int key:map.keySet()){
            int n=map.get(key);
            count+=(long)n*(n-1)/2;
        }
        return (int)(count%(1e9+7));
    }
    private int getreverse(int num) {
        int res=0;
        int temp=0;
        while(num!=0){
            temp=num%10;
            res*=10;
            res+=temp;
            num/=10;
        }
        return res;
    }
}
