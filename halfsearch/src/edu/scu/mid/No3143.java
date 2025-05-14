package edu.scu.mid;

public class No3143 {
    public int maxPointsInsideSquare(int[][] points, String s) {
        //二分边长
        int maxlen=0;
        for (int i = 0; i < points.length; i++) {
            maxlen = Math.max(maxlen, Math.max(Math.abs(points[i][0]), Math.abs(points[i][1])));
        }
        //on
        int left=0;int right=maxlen;
        //ologn
        while(left<=right) {
            int mid=left+(right-left>>1);
            if(check(points,s,mid)!=-1) {
                //还可以增大边长
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return check(points,s,right);
    }
    private int check(int[][] points, String s,int len) {
        boolean[] hash=new boolean[26];
        int count=0;
        //on
        for (int i = 0; i < points.length; i++) {
            if(Math.abs(points[i][0])<=len && Math.abs(points[i][1])<=len) {
                if(hash[s.charAt(i)-'a']) {
                    return -1;
                }
                count++;
                hash[s.charAt(i)-'a']=true;
            }
        }
        return count;
    }
}
