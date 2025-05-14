package edu.scu.mystack;

public class No856 {
    public int scoreOfParentheses(String s) {
        int res=0;
        int precount=0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                precount++;
            }else{
                precount--;
                if(s.charAt(i-1)!=')'){
                    //表示当前后括号不是包围后括号需要计数
                    res+=(int)Math.pow(2,precount);
                }
            }
        }
        return res;
    }
}
