package edu.scu.mid;

public class No875 {
    public int minEatingSpeed(int[] piles, int h) {
        int maxspeed=0;
        for (int i = 0; i < piles.length; i++) {
            maxspeed = Math.max(maxspeed, piles[i]);
        }
        return getspeed(piles, h, maxspeed);
    }
    private int getspeed(int[] piles,int h,int maxspeed){
        int leastspeed=1;int mostspeed=maxspeed;
        while (leastspeed<=mostspeed){
            int mid=leastspeed+(mostspeed-leastspeed>>1);
            long temp=0;
            for (int i = 0; i < piles.length; i++) {
                temp+=(piles[i]-1)/mid+1;
            }
            if(temp<=h){
                mostspeed=mid-1;
            }else{
                leastspeed=mid+1;
            }
        }
        return leastspeed;
    }
}
