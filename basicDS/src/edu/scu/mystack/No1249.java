package edu.scu.mystack;

public class No1249 {
    public String minRemoveToMakeValid(String s) {
        int precount=0;
        StringBuilder sb=new StringBuilder();
        for(char c:s.toCharArray()){
            if(c=='('){
                sb.append(c);
                precount++;
            }else if(c==')'){
                if(precount!=0){
                    precount--;
                    sb.append(c);
                }
            }else{
                sb.append(c);
            }
        }
        int tempindex=sb.length()-1;
        while(precount>0){
            if (sb.charAt(tempindex)=='('){
                sb.deleteCharAt(tempindex);
                precount--;
            }
            tempindex--;
        }
        return sb.toString();
    }
}
