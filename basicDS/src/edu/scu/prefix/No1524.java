package edu.scu.prefix;

import java.util.HashMap;

public class No1524 {
    public int numOfSubarrays(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        int sum = 0;
        long count=0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(sum%2==0){
                count+=map.get(1);
            }else{
                count+=map.get(0);
            }
            map.put(sum%2,map.getOrDefault(sum%2,0)+1);
        }
        return (int)(count%(1e9+7));
    }
}
