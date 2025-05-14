package edu.scu.mystack;

import java.util.Stack;

public class No394 {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> str = new Stack<>();
        //Stack<Integer> num=new Stack<>();
        int index=0;int temp=0;
        char[] chars = s.toCharArray();
        while(index < chars.length){
            if(chars[index]==']'){
                char p;
                int presize=sb.length();
                while((p=str.pop())!='['){
                    sb.insert(presize,p);
                }
                int count=0;int d=1;
                while(!str.isEmpty()&&Character.isDigit(str.peek())){
                    p=str.pop();
                    count+=(p-'0')*d;
                    d=d*10;
                }
                String tool=sb.substring(0,sb.length());
                while(count>1){
                    sb.append(tool);
                    count--;
                }
            }else{
                str.push(chars[index]);
            }
            index++;
        }
        int size=sb.length();
        while(!str.isEmpty()){
            sb.insert(size,str.pop());
        }
        return sb.toString();
    }
}
