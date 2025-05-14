package edu.scu.prefix;

public class No2559 {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] res=new int[words.length];
        int[] prefix=new int[words.length];
        prefix[0]=judge(words[0])?1:0;
        for (int i = 1; i < words.length; i++) {
            String str=words[i];
            prefix[i]=judge(str)?prefix[i-1]+1:prefix[i-1];
        }
        for (int i = 0; i < queries.length; i++) {
            int start=queries[i][0];
            int end=queries[i][1];
            res[i]=start==0?prefix[end]:prefix[end]-prefix[start-1];
        }
        return res;
    }
    private boolean judge(String s){
        return (s.startsWith("a")||s.startsWith("e")||s.startsWith("i")||s.startsWith("o")||s.startsWith("u"))&&(s.endsWith("a")||s.endsWith("e")||s.endsWith("i")||s.endsWith("o")||s.endsWith("u"));
    }
}
