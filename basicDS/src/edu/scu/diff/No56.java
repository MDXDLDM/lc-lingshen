package edu.scu.diff;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class No56 {
    public int[][] merge(int[][] intervals) {
        List<Integer[]> temp = new LinkedList<>();
        TreeSet<Integer> on=new TreeSet<>();
        TreeSet<Integer> off=new TreeSet<>();
        for (int i = 0; i < intervals.length; i++) {
            on.add(intervals[i][0]);
            off.add(intervals[i][1]);
        }
        int dec=0;int startindex=0;int lastindex=0;
        while(!on.isEmpty()&&!off.isEmpty()){
            if(lastindex==on.first()){
                dec++;
                on.pollFirst();
            }
            if(lastindex==off.first()){
                dec--;
                off.pollFirst();
            }
            if(dec<=0){
                temp.add(new Integer[]{startindex,lastindex});
            }
        }
        return new int[1][1];
    }
}
