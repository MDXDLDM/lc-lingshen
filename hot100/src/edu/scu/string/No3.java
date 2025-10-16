package edu.scu.string;

import java.util.HashMap;

public class No3 {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> has = new HashMap<>();
        HashMap<Character, Integer> target = new HashMap<>();
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        for(char c : chars){
            has.put(c, has.getOrDefault(c, 0) + 1);
        }
        for(char c : chart){
            target.put(c, target.getOrDefault(c, 0) + 1);
            if(!has.containsKey(c)||has.get(c) <target.get(c)){
                return "";
            }
        }
        int tobecover=target.keySet().size();
        int firstindex=0;int lastindex=0;
        int res=Integer.MAX_VALUE;
        int resfirstindex=0;int reslastindex=0;
        while(!target.containsKey(chars[firstindex])){
            firstindex++;
        }
        lastindex=firstindex;
        while(lastindex<chart.length){
            char c = chars[lastindex];
            if(target.containsKey(c)){
                target.put(c, target.get(c)-1);
                if(target.get(c)<=0){
                    tobecover--;
                }
            }
            lastindex++;
        }
        if(lastindex==chars.length){
            return s.substring(firstindex,lastindex);
        }
//        if(check(target)){
//            resfirstindex=firstindex;
//            reslastindex=lastindex;
//        }
        while(lastindex<=chars.length){
            if(tobecover==0) {
                //boolean out=false;
                while(firstindex<lastindex){
                    if(target.containsKey(chars[firstindex])){
                        if(target.get(chars[firstindex])<0){
                            target.put(chars[firstindex], target.get(chars[firstindex])+1);
                        }else{
                            break;
                        }
                    }
                    firstindex++;
                }
                if (lastindex - firstindex < res) {
                    resfirstindex = firstindex;
                    reslastindex = lastindex;
                    res = lastindex - firstindex;
                }
            }
            if(lastindex==chars.length){
                break;
            }
            if(target.containsKey(chars[lastindex])){
                target.put(chars[lastindex], target.get(chars[lastindex])-1);
                if (target.get(chars[lastindex])==0){
                    tobecover--;
                }
            }
            lastindex++;
        }
        return s.substring(resfirstindex, reslastindex);
    }
    private boolean check(HashMap<Character,Integer> map){
        for(char c : map.keySet()){
            if(map.get(c)>0){
                return false;
            }
        }
        return true;
    }
}
