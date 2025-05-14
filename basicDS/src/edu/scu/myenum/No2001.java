package edu.scu.myenum;

import java.util.HashMap;

public class No2001 {
    public long interchangeableRectangles(int[][] rectangles) {
        //double[] result = new double[rectangles.length];
        HashMap<Double, Integer> map = new HashMap<>();
        for (int i = 0; i < rectangles.length; i++) {
            double temp=(double) rectangles[i][0]/rectangles[i][1];
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        long res=0;
        for(double key : map.keySet()) {
            int count = map.get(key);
            res+= (long) (count - 1) *count/2;
        }
        return res;
    }
}
