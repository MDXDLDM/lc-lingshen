package edu.scu.diff;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class No57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length==0){
            return new int[][]{new int[]{newInterval[0],newInterval[1]}};
        }
        int firstindex=0;
        while(firstindex<intervals.length){
            if(intervals[firstindex][0]>newInterval[1]){
                break;
            }
            firstindex++;
        }
        //firstindex及以后的下标不用合并直接输出
        int start=0;
        while(start<intervals.length){
            if(intervals[start][1]>=newInterval[0]){
                break;
            }
            start++;
        }
        start--;
        //start及以前的起点都比新插入的起点小
        if (start<intervals.length-1) {
            newInterval[0]=Math.min(newInterval[0],intervals[start+1][0]);
        }
        if (firstindex>0) {
            newInterval[1]=Math.max(newInterval[1],intervals[firstindex-1][1]);
        }
        System.out.println(start+" "+firstindex);
        List<int[]> temp=new LinkedList<>();
        int index=0;boolean isplaced=false;
        while(index<intervals.length){
            if(index<=start||index>=firstindex){
                temp.add(intervals[index]);
            }else{
                temp.add(new int[]{newInterval[0],newInterval[1]});
                index=firstindex-1;
                isplaced=true;
            }
            index++;
        }
        if(!isplaced){
            temp.add(new int[]{newInterval[0],newInterval[1]});
            Collections.sort(temp,(p,q)->p[0]-q[0]);
        }
        return temp.toArray(new int[temp.size()][]);
    }
}
