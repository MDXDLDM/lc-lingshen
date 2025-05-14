package edu.scu.mid;

public class No2730 {
    public int longestSemiRepetitiveSubstring(String s) {
        int max=1;int current=1;
        int firstindex=0;int lastindex=1;
        int flag=0;
        while(lastindex<s.length()){
            current++;
            if(s.charAt(lastindex)==s.charAt(lastindex-1)){
                if(flag==0){
                    flag=1;
                }else{
                    while(s.charAt(firstindex)!=s.charAt(firstindex+1)){
                        firstindex++;
                        current--;
                    }
                    firstindex++;current--;
                }
            }
            lastindex++;
            max=Math.max(max,current);
        }
        return max;
    }
}
