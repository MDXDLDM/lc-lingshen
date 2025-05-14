package edu.scu.mid;

import java.util.Arrays;

public class No3281 {
    public int maxPossibleScore(int[] start, int d) {
        Arrays.sort(start);
        int left=0;int right=start[start.length-1]-start[0]+d;
        while (left<=right) {
            int mid=left+(right-left>>1);
            if(check(start,d,mid)){
                //表示此时的d仍可增大
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return right;
    }
    private boolean check(int[] start, int d,int top) {
        int current=start[0];
        for (int i = 1; i < start.length; i++) {
            if(start[i]-current+d<top){
                return false;
            }
            current=Math.max(current+top,start[i]);
        }
        return true;
    }
}
