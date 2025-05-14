package edu.scu.myqueue;

public class No649 {
    public String predictPartyVictory(String senate) {
        int Rbancount=0;int Rrestcount=0;
        int Dbancount=0;
        boolean[] flag = new boolean[senate.length()];
        char[] chars = senate.toCharArray();
        for (char c : chars) {
            if (c=='R')Rrestcount++;
        }
        int Drestcount=senate.length()-Rrestcount;
        int index=0;
        while(true){
            if (Rrestcount==0)return "Dire";
            if (Drestcount==0)return "Radiant";
            if (!flag[index]){
                if (chars[index]=='R'){
                    if (Dbancount>0){
                        Dbancount--;
                        Rrestcount--;
                        flag[index]=true;
                    }else{
                        Rbancount++;
                    }
                }else{
                    if (Rbancount>0){
                        Rbancount--;
                        Drestcount--;
                        flag[index]=true;
                    }else{
                        Dbancount++;
                    }
                }
            }
            index++;
            index%=senate.length();
        }
    }
}
