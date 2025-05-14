package edu.scu.prefix;

import java.util.Arrays;
import java.util.Collections;

public class No3152 {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        if(nums.length==1){
            boolean[] f=new boolean[queries.length];
            Arrays.fill(f,true);
            return f;
        }
        int count=0;
        int[] judge=new int[nums.length];
        boolean[] result=new boolean[queries.length];
        for (int i = 0; i < nums.length-1; i++) {
            judge[i]=count;
            if(nums[i+1]%2==nums[i]%2){
                count++;
            }
        }
        judge[queries.length-1]=nums[queries.length-1]%2==nums[queries.length-2]%2?++count:count;
        for (int i = 0; i < queries.length; i++) {
            int start=queries[i][0];
            int end=queries[i][1];
            result[i]=judge[start]==judge[end];
        }
        return result;
    }

}
