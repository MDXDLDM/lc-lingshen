package edu.scu.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class No2982 {
    public int maximumLength(String s) {
        //至少出现三次<->若最长段大于等于5个，那么答案刚好为5-2=3或者n-2=n-2个，也就是在降序list中的第三个数
//        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
//        int len=1;ArrayList<Integer> list = new ArrayList<>();
//        list.add(len);
//        map.put(s.charAt(0),list);
//        for(int i=1;i<s.length();i++){
//            if(s.charAt(i)==s.charAt(i-1)){
//                len++;
//            }else{
//                len=1;
//            }
//            if(!map.containsKey(s.charAt(i))){
//                ArrayList<Integer> temp = new ArrayList<>();
//                map.put(s.charAt(i),temp);
//            }
//            map.get(s.charAt(i)).add(len);
//        }
//        int max=0;
//        for(char key:map.keySet()){
//            ArrayList<Integer> temp = map.get(key);
//            if(temp.size()>=3){
//                Collections.sort(temp);
//                max = Math.max(max,temp.get(temp.size()-3));
//            }
//        }
//        return max;
        ArrayList<Integer>[] lists = new ArrayList[26];
        Arrays.setAll(lists, i -> new ArrayList<>());

        int len=0;
        for(int i=0;i<s.length();i++){
            if(i==0||s.charAt(i)==s.charAt(i-1)){
                ++len;
            }else{
                len=1;
            }
            lists[s.charAt(i)-'a'].add(len);
        }
        int max=-1;
        for(int i=0;i<lists.length;i++){
            ArrayList<Integer> temp=lists[i];
            if(temp.size()>=3){
                Collections.sort(temp);
                max=Math.max(max,temp.get(temp.size()-3));
            }
        }
        return max;
    }
}
