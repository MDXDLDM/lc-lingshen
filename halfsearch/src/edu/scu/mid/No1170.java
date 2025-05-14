package edu.scu.mid;

import java.util.Arrays;

public class No1170 {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] result = new int[queries.length];
        int[] newreq = new int[queries.length];
        int[] newwords = new int[words.length];
        for (int i = 0; i < queries.length; i++) {
            char[] q = queries[i].toCharArray();
            Arrays.sort(q);
            int count = 1;
            for (int j = 1; j < q.length; j++) {
                if(q[j] == q[0]) count++;
                else break;
            }
            newreq[i] = count;
        }
        for (int i = 0; i < words.length; i++) {
            char[] w = words[i].toCharArray();
            Arrays.sort(w);
            int count = 1;
            for (int j = 1; j < w.length; j++) {
                if(w[j] == w[0]) count++;
                else break;
            }
            newwords[i] = count;
        }
        Arrays.sort(newwords);
        for (int i = 0; i < newreq.length; i++) {
            result[i]= words.length-findstart(newwords,newreq[i]);
        }
        return result;
    }
    private int findstart(int[] nums,int target){
        int startindex=0;
        int lastindex=nums.length-1;//左闭右闭
        while(startindex<=lastindex){
            int mid=(lastindex-startindex>>1)+startindex;
            if(nums[mid]>=target){
                lastindex=mid-1;
            }else{
                startindex=mid+1;
            }
        }
        return startindex;
    }
}
