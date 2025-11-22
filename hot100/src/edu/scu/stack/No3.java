package edu.scu.stack;

public class No3 {

    public String decodeString(String s) {
        return deepConstruct(s);

    }
    int index=0;
    private String deepConstruct(String s){
        int num=0;
        StringBuilder sb=new StringBuilder();
        while (index<s.length()) {
            char c=s.charAt(index);
            index++;
            if(c>='0'&&c<='9'){
                num=num*10+c-'0';
            }else if(c=='['){
                String deeper=deepConstruct(s);
                for(int j=0;j<num;j++){
                    sb.append(deeper);
                }
                num=0;
            }else if(c==']'){
                break;
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
