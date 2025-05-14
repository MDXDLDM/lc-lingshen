package edu.scu.myheap;

import java.util.*;

public class No767 {
    public String reorganizeString(String s) {
        char[] chars=new char[s.length()];
        TreeMap<Character,Integer> map = new TreeMap<>();
        for(char c : s.toCharArray()){
            if (map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }
        List<Map.Entry<Character,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a,b)->b.getValue()-a.getValue());
        int maxcount=list.get(0).getValue();
        if (maxcount>1+s.length()-maxcount){
            return "";
        }
        int index=0;
        for (Map.Entry<Character,Integer> entry : list){
            int count=entry.getValue();
            char key=entry.getKey();
            while(count-->0){
                chars[index]=key;
                index+=2;
                if(index>=s.length()){
                    index=1;
                }
            }
        }
        return String.valueOf(chars);
    }
}
