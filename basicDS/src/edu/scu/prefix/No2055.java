package edu.scu.prefix;

import java.util.TreeSet;

public class No2055 {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int[] pre=new int[s.length()];
        TreeSet<Integer> set=new TreeSet<>();
        if(s.charAt(0)=='*'){
            pre[0]=1;
        }else{
            set.add(0);
        }
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i)=='*'){
                pre[i]=pre[i-1]+1;
            }else{
                set.add(i);
                pre[i]=pre[i-1];
            }
        }
        int[] ans=new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start=queries[i][0];
            int end=queries[i][1];
            Integer jstart=set.ceiling(start);
            Integer jend=set.floor(end);
            if(jstart!=null && jend!=null && jstart<=end && jend>=start){
                System.out.println(jstart+" "+jend+" "+pre[jstart]+" "+pre[jend]);
                ans[i]=pre[jend]-pre[start];
            }else{
                ans[i]=0;
            }
        }
        return ans;
    }
}
