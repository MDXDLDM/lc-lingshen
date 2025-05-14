package edu.scu.mid;

import java.util.Arrays;
import java.util.Comparator;

public class No2070 {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0]==0?o1[1]-o2[1]:o1[0]-o2[0];
            }
        });
        int max=items[0][1];
        for(int i=1;i<items.length;i++){
            if(items[i][1]>max){
                max=items[i][1];
            }else{
                items[i][1]=max;
            }
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int index=findindex(items, queries[i])-1;
            res[i]=index>=0?items[index][0]:0;
        }
        return res;
    }
    private int findindex(int[][] items, int target) {
        int firstindex=0;int lastindex=items.length-1;
        while(firstindex<=lastindex){
            int mid=firstindex+(lastindex-firstindex>>1);
            if(items[mid][0]>target){
                lastindex=mid-1;
            }else{
                firstindex=mid+1;
            }
        }
        return firstindex;
    }
}
