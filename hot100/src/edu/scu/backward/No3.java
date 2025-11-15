package edu.scu.backward;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No3 {
    private static final char[][] alpha={{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
    List<String> result=new ArrayList<>();
    StringBuilder sb=new StringBuilder();
    public List<String> letterCombinations(String digits) {
        char[] chars=digits.toCharArray();
        int[] ints=new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            ints[i]=chars[i]-'2';
        }
        dfs(ints,0);
        return result;
    }
    private void dfs(int[] ints,int index) {
        if (index==ints.length) {
            result.add(sb.toString());
            return;
        }
        char[] chars=alpha[ints[index]];
        for (char c:chars) {
            sb.append(c);
            dfs(ints,index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
