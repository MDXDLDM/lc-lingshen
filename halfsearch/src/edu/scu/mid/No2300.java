package edu.scu.mid;

import java.util.Arrays;

public class No2300 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] result = new int[spells.length];
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            int start=getstart(spells[i],potions,success);
            result[i]=potions.length-start;
        }
        return result;
    }
    private int getstart(int key,int[] nums,long target) {
        int firstindex=0;int lastindex=nums.length-1;//左闭右闭
        while(firstindex<=lastindex){
            int mid=firstindex+(lastindex-firstindex>>1);
            long temp=nums[mid];
            if(temp*key<target){
                firstindex=mid+1;
            }else{
                lastindex=mid-1;
            }
        }
        return firstindex;
    }
}
