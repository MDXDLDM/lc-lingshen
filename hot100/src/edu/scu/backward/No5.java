package edu.scu.backward;

import java.util.ArrayList;
import java.util.List;

public class No5 {
    List<String> list=new ArrayList<String>();
    StringBuilder sb=new StringBuilder();
    public List<String> generateParenthesis(int n) {
        dfs(n,0);
        return list;
    }
    private void dfs(int leftNum, int rightNum) {
        if(leftNum==rightNum&&leftNum==0){
            list.add(sb.toString());
            return;
        }
        if (leftNum > 0) {
            sb.append('(');
            dfs(leftNum - 1, rightNum+1);
            sb.deleteCharAt(sb.length()-1);
        }
        if (rightNum > 0) {
            sb.append(')');
            dfs(leftNum, rightNum-1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
