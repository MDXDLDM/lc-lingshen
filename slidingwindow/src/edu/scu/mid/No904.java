package edu.scu.mid;

import java.util.HashMap;

public class No904 {
    public int totalFruit(int[] fruits) {
        int current=0;int max=0;
        int firstindex=0;int lastindex=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        while(lastindex<fruits.length){
            map.put(fruits[lastindex],map.getOrDefault(fruits[lastindex],0)+1);
            current++;
            if(map.size()==3){
                while(map.get(fruits[firstindex])!=1){
                    map.put(fruits[firstindex],map.get(fruits[firstindex])-1);
                    firstindex++;
                    current--;
                }
                map.remove(fruits[firstindex]);
                current--;firstindex++;
            }
            max=Math.max(max,current);
            lastindex++;
        }
        return max;
    }
}
