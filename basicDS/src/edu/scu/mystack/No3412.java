package edu.scu.mystack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class No3412 {
    public long calculateScore(String s) {
        long res=0;
        HashMap<Character, List<Integer>> map=new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char temp=(char)('a'+25-s.charAt(i)+'a');
            if(map.containsKey(temp)){
                if (!map.get(temp).isEmpty()){
                    int flag=map.get(temp).get(map.get(temp).size()-1);
                    res+=i-flag;
                    map.get(temp).remove(map.get(temp).size()-1);
                    continue;
                }
            }
            if(!map.containsKey(s.charAt(i))){
                List<Integer> list=new ArrayList<>();
                map.put(s.charAt(i),list);
            }
            map.get(s.charAt(i)).add(i);
        }
        return res;
    }
}
