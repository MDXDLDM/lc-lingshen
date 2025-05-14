package edu.scu.diff;

public class No1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] on=new int[1001];
        int[] off=new int[1001];
        for (int i = 0; i < trips.length; i++) {
            on[trips[i][1]]+=trips[i][0];
            off[trips[i][2]]+=trips[i][0];
        }
        int current=0;
        for (int i = 0; i < 1001; i++) {
            current+=on[i];
            current-=off[i];
            if(current>capacity)return false;
        }
        return true;
    }
}
