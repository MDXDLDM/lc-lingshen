package edu.scu.diff;

public class No2406 {
    public int minGroups(int[][] intervals) {
        int min=0;
        int max=0;
        for (int i = 0; i < intervals.length; i++) {
            min = Math.min(min, intervals[i][0]);
            max = Math.max(max, intervals[i][1]);
        }
        int[] on=new int[max-min+1];
        int[] off=new int[max-min+1];
        for (int i = 0; i < intervals.length; i++) {
            on[intervals[i][0]-min]++;
            off[intervals[i][1]-min]++;
        }
        int count=0;int res=0;
        for(int i=min;i<=max;i++){
            count+=on[i];
            count-=off[i];
            res=Math.max(res,count);
        }
        return res;
    }
}
