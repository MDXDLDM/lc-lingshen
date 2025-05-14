package edu.scu.easy;

import java.util.HashMap;

public class No3090 {
    public int maximumLengthSubstring(String s) {
        int current=0;int max=0;
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        int firstindex=0;int lastindex=0;
        while(lastindex<s.length()){
            char b=s.charAt(lastindex);
            if(map.containsKey(b)&&map.get(b)==2){
                while(s.charAt(firstindex)!=b){
                    current--;
                    if(map.get(s.charAt(firstindex))==1){
                        map.remove(s.charAt(firstindex));
                    }else{
                        map.put(s.charAt(firstindex),map.getOrDefault(s.charAt(firstindex),0)-1);
                    }
                    firstindex++;
                }
                firstindex++;lastindex++;
                System.out.println(current);
                continue;
            }
            map.put(b,map.getOrDefault(b,0)+1);
            lastindex++;current++;
            System.out.println(current);
            max=Math.max(max,current);
        }
        return max;
    }
}
