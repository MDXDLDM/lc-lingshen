package edu.scu.slidingWindow;

import java.util.HashMap;
import java.util.HashSet;

public class No1 {
    public int lengthOfLongestSubstring(String s) {
//        if (s == null || s.isEmpty()) return 0;
//        int[] characters = new int[26];
//        int res=0;
//        int firstindex=0;int lastindex=0;
//        while(lastindex<s.length()){
//            char ch=s.charAt(lastindex);
//            if(characters[ch-'a']==0){
//                characters[ch-'a']++;
//            }else{
//                while(s.charAt(firstindex)!=ch){
//                    characters[s.charAt(firstindex)-'a']--;
//                    firstindex++;
//                }
//                firstindex++;
//            }
//            res=Math.max(res,lastindex-firstindex+1);
//            lastindex++;
//        }
//        return res;
        HashSet<Character> set = new HashSet<>();
        int res=0;
        int firstindex=0;int lastindex=0;
        while(lastindex<s.length()){
            char c=s.charAt(lastindex);
            while(set.contains(c)){
                set.remove(s.charAt(firstindex));
                firstindex++;
            }
            set.add(c);
            res=Math.max(res,lastindex-firstindex+1);
            lastindex++;
        }
        return res;
    }
}
