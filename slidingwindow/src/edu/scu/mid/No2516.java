package edu.scu.mid;

public class No2516 {
    public int takeCharacters(String s, int k) {
        int[] hash=new int[3];
        for(int i=0;i<s.length();i++){
            hash[s.charAt(i)-'a']++;
        }
        if(hash[0]<k||hash[1]<k||hash[2]<k)return -1;
        int firstindex=0;int lastindex=0;
        int max=0;
        while(lastindex<s.length()){
            hash[s.charAt(lastindex)-'a']--;
            while(hash[0]<k||hash[1]<k||hash[2]<k&&firstindex<=lastindex){
                hash[s.charAt(firstindex)-'a']++;
                firstindex++;
            }
            System.out.println(firstindex+" "+lastindex);
            max=Math.max(max,lastindex-firstindex+1);
            lastindex++;
        }
        return s.length()-max;
    }
}
