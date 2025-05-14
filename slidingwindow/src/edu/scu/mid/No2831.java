package edu.scu.mid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class No2831 {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            if(!map.containsKey(nums.get(i))){
                map.put(nums.get(i), new ArrayList<>());
            }
            map.get(nums.get(i)).add(i);
        }
        int max=0;
        for(int key: map.keySet()){
            if(map.get(key).size()==1){
                max=max==0?1:max;
            }else{
                int firstindex=0;int lastindex=0;
                while(lastindex<map.get(key).size()){
                    while(map.get(key).get(lastindex)-map.get(key).get(firstindex)-(lastindex-firstindex)>k) {
                        firstindex++;
                    }
                    max=Math.max(max,lastindex-firstindex+1);
                    lastindex++;
                }
            }
        }
        return max;
    }
}
