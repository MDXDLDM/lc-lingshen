package edu.scu.mystack;

public class No678 {
    public boolean checkValidString(String s) {
        int maxcount=0;
        int mincount=0;
        for (char c : s.toCharArray()) {
            if (c=='('){
                maxcount++;
                mincount=mincount<0?1:mincount+1;
            }else if (c=='*'){
                maxcount++;
                mincount--;
            }else{
                mincount--;
                maxcount--;
            }
            if (maxcount<0)return false;
        }
        return mincount<=0;
    }
}
