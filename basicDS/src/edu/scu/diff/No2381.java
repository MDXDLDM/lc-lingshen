package edu.scu.diff;

public class No2381 {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] dec=new int[s.length()];
        for (int i = 0; i < shifts.length; i++) {
            dec[shifts[i][0]]+=shifts[i][2]==1?1:-1;
            if(shifts[i][1]<s.length()-1){
                dec[shifts[i][1]+1]-=shifts[i][2]==1?1:-1;
            }
        }
        char[] ch=s.toCharArray();
        int count=0;
        for (int i = 0; i < ch.length; i++) {
            count+=dec[i];
            int index=ch[i]-'a';
            System.out.println(count);
            index=((index+count)%26+26)%26;
            ch[i]= (char) ('a'+index);
        }
        return new String(ch);
    }
}
