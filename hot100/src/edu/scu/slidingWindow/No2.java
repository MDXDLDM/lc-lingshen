package edu.scu.slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class No2 {
    public List<Integer> findAnagrams(String s, String p) {
        int firstindex = 0;
        int lastindex = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) - 1);
        }
        int len=p.length();
        int flen=s.length();
        List<Integer> ans = new ArrayList<>();
        if(len>flen) return ans;
        while(lastindex<len){
            char c = s.charAt(lastindex);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if(map.get(c)==0){
                map.remove(c);
            }
            lastindex++;
        }

        while(lastindex<flen){
            if (map.size()==0){
                ans.add(firstindex);
            }
            if (lastindex==flen-1){
                break;
            }
            char first = s.charAt(firstindex);
            lastindex++;
            char last = s.charAt(lastindex);
            map.put(first, map.getOrDefault(first, 0) - 1);
            map.put(last, map.getOrDefault(last, 0) + 1);
            if (map.get(first)==0){
                map.remove(first);
            }
            if (map.get(last)!=null&&map.get(last)==0){
                map.remove(last);
            }
        }
        return ans;
    }
}
