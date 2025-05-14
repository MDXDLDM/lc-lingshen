package edu.scu.mystack;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class No3170 {
    public String clearStars(String s) {
        TreeMap<Character, List<Integer>> map = new TreeMap<>();
        boolean[] flag = new boolean[s.length()];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c=='*'){
                flag[i] = true;
                if(!map.isEmpty()){
                    List<Integer> temp=map.get(map.firstKey());
                    int index=temp.get(temp.size()-1);
                    flag[index] = true;
                    temp.remove(temp.size()-1);
                    if(temp.isEmpty()){
                        map.remove(map.firstKey());
                    }
                }
            }else{
                if(!map.containsKey(c)){
                    map.put(c, new ArrayList<>());
                }
                map.get(c).add(i);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if(flag[i]){

            }else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
