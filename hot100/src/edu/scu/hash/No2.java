package edu.scu.hash;

import java.util.*;

public class No2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(s);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
}
