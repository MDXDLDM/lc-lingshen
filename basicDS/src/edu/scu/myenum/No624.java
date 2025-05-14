package edu.scu.myenum;

import java.util.List;

public class No624 {
    public int maxDistance(List<List<Integer>> arrays) {
        int min=arrays.get(0).get(0);int max=arrays.get(0).get(arrays.get(0).size()-1);
        //int tempmax;int tempmin;
        int res=0;
        int len=arrays.size();
        for (int i = 1; i < len; i++) {
            //tempmin=min;
            res=Math.max(res, Math.max(max-arrays.get(i).get(0), arrays.get(i).get(arrays.get(i).size()-1)-min));
            min=Math.min(min,arrays.get(i).get(0));
            //tempmax=max;
            max=Math.max(max,arrays.get(i).get(arrays.get(i).size()-1));
        }
        return res;
    }
}
