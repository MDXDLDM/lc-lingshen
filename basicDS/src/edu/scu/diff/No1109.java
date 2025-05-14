package edu.scu.diff;

public class No1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] on=new int[n];
        int[] off=new int[n];
        for (int i = 0; i < bookings.length; i++) {
            int start=bookings[i][0];
            int end=bookings[i][1];
            on[start]+=bookings[i][2];
            off[end-1]+=bookings[i][2];
        }
        int[] res=new int[n];
        int temp=0;
        for (int i = 0; i < n; i++) {
            temp+=on[i];
            temp-=off[i];
            res[i]=temp;
        }
        return res;
    }
}
