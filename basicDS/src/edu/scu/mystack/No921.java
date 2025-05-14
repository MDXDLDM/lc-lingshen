package edu.scu.mystack;

public class No921 {
    public int minAddToMakeValid(String s) {
        int res=0;
        int precount=0;
        for(char c:s.toCharArray()){
            if(c=='('){
                precount++;
            }else{
                if(precount>0){
                    precount--;
                }else{
                    res++;
                }
            }
        }
        return res+precount;
    }
}
