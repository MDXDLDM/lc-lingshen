package edu.scu.myenum;

public class No1014 {
    public int maxScoreSightseeingPair(int[] values) {
        int max=0;
        int pre=values[0];
        for (int i = 1; i < values.length; i++) {
            max=Math.max(max,values[i]+pre-i);
            pre=Math.max(pre,values[i]+i);
        }
        return max;
    }
}
