package edu.scu.myenum;

import java.util.HashMap;

public class No447 {
    public int numberOfBoomerangs(int[][] points) {
        int sum=0;
        for (int i = 0; i < points.length; i++) {
            HashMap<Integer,Integer> map=new HashMap<>();
            for(int j=0;j<points.length;j++){
                if(j==i)continue;
                int dis= (int) (Math.pow((points[i][0]-points[j][0]),2)+Math.pow((points[i][1]-points[j][1]),2));
                int temp=map.getOrDefault(dis,0);
                sum+=temp*2;
                map.put(dis,temp+1);
            }
        }
        return sum;
    }
}
