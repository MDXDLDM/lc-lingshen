package edu.scu.mystack;

import java.util.Stack;

public class No1209 {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int count=0;char temp=s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sb.append(c);
            if (c==temp){
                count++;
            }else{
                count=1;
                temp=c;
            }
            if (count==k){
                sb.delete(sb.length()-k,sb.length());
                if (sb.length()==0){
                    count=0;
                    temp=' ';
                }else{
                    temp=sb.charAt(sb.length()-1);
                    count=1;
                    for (int j=sb.length()-2;j>=0;j--){
                        if (sb.charAt(j)==temp){
                            count++;
                        }else{
                            break;
                        }
                    }
                }
            }
        }
        return sb.toString();
    }
}
