package edu.scu.diff;

import java.util.Arrays;
import java.util.List;

public class No2848 {
    public int numberOfPoints(List<List<Integer>> nums) {
        int count=0;
        int[] judge=new int[101];
        for(List<Integer> num:nums){
            int start=num.get(0);
            int end=num.get(1);
            Arrays.fill(judge,start,end+1,1);
        }
        for (int i = 0; i < 101; i++) {
            count+=judge[i];
        }
        return count;
    }
}
