package edu.scu.mid;

import java.util.Arrays;

public class No2090 {
    public int[] getAverages(int[] nums, int k) {
        System.out.println(nums.length);
        if(nums.length-k*2-1<0){
            int[] res = new int[nums.length];
            Arrays.fill(res,-1);
            return res;
        }
        int[] res = new int[nums.length];
        long sum=0;int firstindex=0;int lastindex=0;
        for(;lastindex<2*k+1;lastindex++){
            sum+=nums[lastindex];
        }
        res[k]= (int) (sum/(k*2+1));
        for(int i=k+1;i<nums.length-k;i++){
            sum-=nums[firstindex++];
            sum+=nums[lastindex++];
            res[i]= (int) (sum/(2*k+1));
        }
        for(int i=0;i<k;i++){
            res[i]=-1;
        }
        for(int i= nums.length-k;i<nums.length;i++){
            res[i]=-1;
        }
        return res;
    }
}
