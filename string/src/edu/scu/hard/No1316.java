package edu.scu.hard;

import java.util.HashMap;
import java.util.HashSet;

public class No1316 {
    String s;
    int count=0;
    HashMap<String,Integer> map=new HashMap<>();
    public int distinctEchoSubstrings(String text) {
        //this.s = text;
        //dfs(0,0);
        HashSet<String> set=new HashSet<>();
        for(int i=0;i<text.length();i++){
            for(int j=i+1;j<=text.length();j++){
                if((j-i)%2==0){
                    int mid=(j+i)/2;
                    if(text.substring(i,mid).equals(text.substring(mid,j))){
                        set.add(text.substring(i,j));
                    }
                    //ismadeby(text.substring(i,j));
                }
            }
        }
        return set.size();
    }
    private void dfs(int start,int end){
        if(end > s.length()){
            return;
        }
        if(end<=s.length()){
            dfs(start,end+1);
        }
        if((end-start)%2==0){
            String now=s.substring(start,end);
            ismadeby(now);
            dfs(end+1,end+1);
        }
    }
    private void ismadeby(String s){
        if(map.containsKey(s)){
            return;
        }
        if(s.length()%2!=0||s.isEmpty())return;
        int right=s.length();
        int left=s.length()/2;
        if(s.substring(0,left).equals(s.substring(left,right))){
            map.put(s,1);
            //count++;
        }

    }

    public static void main(String[] args) {
        System.out.println(new No1316().distinctEchoSubstrings("abcabcabc"));
    }
}
