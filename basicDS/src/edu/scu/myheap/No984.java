package edu.scu.myheap;

public class No984 {
    public String strWithout3a3b(int a, int b) {
        StringBuilder sb=new StringBuilder();
        int acon=0;int bcon=0;
        while(a+b>0){
            if ((a>=b||bcon==2)&&acon<=2){
                sb.append('a');
                a--;
                acon++;bcon=0;
            }else{
                sb.append('b');
                b--;
                bcon++;acon=0;
            }
        }
        return sb.toString();
    }
}
