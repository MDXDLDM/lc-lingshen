package edu.scu.mid;

import java.util.Arrays;

public class No2187 {
    public long minimumTime(int[] time, int totalTrips) {
        Arrays.sort(time);
        long max=time[time.length-1];
        long maxtime= max *totalTrips;
        return getttime(time,maxtime,totalTrips);
    }
    private long getttime(int[] time, long maxtime,int totalTrips) {
        long firsttime=1;long lasttime=maxtime;
        while (firsttime<=lasttime) {
            System.out.println(firsttime+" "+lasttime);
            long mid=firsttime+(lasttime-firsttime>>1);
            long sum=0;
            for(int i=0;i<time.length;i++){
                sum+=(mid/time[i]);
            }
            if(sum<totalTrips){
                firsttime=mid+1;
            }else{
                lasttime=mid-1;
            }
        }
        return firsttime;
    }
}
