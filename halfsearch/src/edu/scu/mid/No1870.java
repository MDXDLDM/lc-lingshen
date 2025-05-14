package edu.scu.mid;

public class No1870 {
    public int minSpeedOnTime(int[] dist, double hour) {
        if(hour<=dist.length-1)return -1;
        int max=0;
        for (int i = 0; i < dist.length; i++) {
            max = Math.max(max, dist[i]);
        }
        max= (int) Math.max(max, dist[dist.length-1]/(hour-dist.length+1));
        return getspeed(dist,hour,max);
    }
    private int getspeed(int[] dist,double hour,int maxspeed) {
        int firstspeed=1;int lastspeed=maxspeed;
        while (firstspeed<=lastspeed) {
            int mid=firstspeed+(lastspeed-firstspeed>>1);
            double temp=0;
            for(int i=0;i<dist.length-1;i++) {
                temp+=dist[i]<=mid?1:(dist[i]-1)/mid+1;
            }
            temp+=(double)dist[dist.length-1]/mid;
            if(temp<=hour) {
                //说明车速还可以降低
                lastspeed=mid-1;
            }else{
                firstspeed=mid+1;
            }
        }
        return lastspeed+1;
    }
}
