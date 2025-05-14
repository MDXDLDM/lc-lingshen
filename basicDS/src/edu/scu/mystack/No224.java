package edu.scu.mystack;

import java.util.Stack;

public class No224 {
    public int calculate(String s) {
        Stack<Integer> num = new Stack<>();
        Stack<Character> operator=new Stack<>();
        int tempcount=0;
        char[] chars=s.toCharArray();
        int index=0;
        while(index<chars.length){
            while(index< chars.length&&Character.isDigit(chars[index])){
                tempcount*=10;
                tempcount+=chars[index]-'0';
                index++;
            }
            num.push(tempcount);
            tempcount=0;
            char ch=chars[index];
            if(ch!=' '){
                if (ch==')'){
                    int b=num.pop();
                    int a=num.pop();
                    char ope=operator.pop();
                    if (ope=='+'){
                        num.push(a+b);
                    }else{
                        num.push(a-b);
                    }
                    operator.pop();//(
                }else{
                    if (ch!='('){
                        char p=operator.peek();
                        if (ch<p){
                            char ope=operator.pop();
                            int b=num.pop();
                            int a=num.pop();
                            if (ope=='+'){
                                num.push(a+b);
                            }else{
                                num.push(a-b);
                            }
                            //operator.push(ch);
                        }
                        //operator.push(ch);
                    }
                    operator.push(ch);
                }
            }
        }
        return operator.isEmpty()?num.pop():-num.pop();
    }
}
