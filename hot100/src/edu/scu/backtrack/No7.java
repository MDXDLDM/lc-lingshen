package edu.scu.backtrack;

import java.util.ArrayList;
import java.util.List;

public class No7 {
    List<List<String>> list=new ArrayList<>();
    List<String> path=new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(s,0);
        return list;
    }
    private void dfs(String s,int index){
        if(index==s.length()){
            list.add(new ArrayList<>(path));
            return;
        }
        for(int i=index+1;i<=s.length();i++){
            String temp=s.substring(index,i);
            if (isReverse(temp)){
                path.add(temp);
                dfs(s,i);
                path.remove(path.size()-1);
            }
        }
    }
    private boolean isReverse(String s){
        int firstindex=0;
        int lastindex=s.length()-1;
        while(firstindex<lastindex){
            if(s.charAt(firstindex)!=s.charAt(lastindex)){
                return false;
            }
            firstindex++;
            lastindex--;
        }
        return true;
    }
}
