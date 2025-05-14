package edu.scu.mystack;

public class No1717 {
    public int maximumGain(String s, int x, int y) {
        return x>y?getresult(s,'a','b',x,y):getresult(s,'b','a',y,x);
    }
    private int getresult(String s,char maxfirst,char maxsecond,int maxvalue,int minvalue) {
        int firstcount = 0;
        int secondcount = 0;
        int res=0;
        for(char c : s.toCharArray()) {
            if(c==maxfirst){
                firstcount++;
            }else if(c==maxsecond){
                if (firstcount>0){
                    res+=maxvalue;
                    firstcount--;
                }else{
                    secondcount++;
                }
            }else{
                res+=minvalue*(Math.min(firstcount,secondcount));
                firstcount=0;secondcount=0;
            }
        }
        res+=minvalue*(Math.min(firstcount,secondcount));
        return res;
    }
}
