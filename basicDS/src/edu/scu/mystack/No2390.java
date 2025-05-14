package edu.scu.mystack;

import java.util.Stack;

public class No2390 {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
