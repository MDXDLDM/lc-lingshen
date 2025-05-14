package edu.scu.myheap;

import java.util.*;

public class No1054 {
    public int[] rearrangeBarcodes(int[] barcodes) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int val : barcodes){
            if (map.containsKey(val)){
                map.put(val, map.get(val)+1);
            }else{
                map.put(val, 1);
            }
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a,b)->b.getValue()-a.getValue());
        int index=0;
        int[] res = new int[barcodes.length];
        for(Map.Entry<Integer,Integer> entry : list){
            int count = entry.getValue();
            int key = entry.getKey();
            while (count-->0){
                res[index] = key;
                index+=2;
                if (index>=barcodes.length){
                    index=1;
                }
            }
        }
        return res;
    }
}
