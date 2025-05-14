package edu.scu.myenum;

import java.util.HashMap;

public class No1010 {
    public int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < time.length; i++) {
            map.put(time[i]%60,map.getOrDefault(time[i]%60,0)+1);
        }
        int sum=0;
        for(int key:map.keySet()){

            if(key>30)continue;
            int value=map.get(key);
            if(key==0||key==30){
                sum+=(value-1)*(value/2);
            }else if(map.containsKey(60-key)){
                sum+=value*map.get(60-value);
            }
        }
        return sum;
    }
}
