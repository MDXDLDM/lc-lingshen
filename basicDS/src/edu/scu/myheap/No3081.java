package edu.scu.myheap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class No3081 {
    public String minimizeStringValue(String s) {
        int[] alpha=new int[26];
        char[] sc=s.toCharArray();
        for(char c:sc){
            if (c!='?'){
                alpha[c-'a']++;
            }
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]==o2[0]?o1[1]-o2[1]:o1[0]-o2[0];
            }
        });
        for(int i=0;i<26;i++){
            pq.offer(new int[]{alpha[i],i});
        }
        PriorityQueue<Character> charpq=new PriorityQueue<>();
        for (int i=0;i< sc.length;i++){
            if (sc[i]=='?'){
                int[] min=pq.poll();
                charpq.offer((char)(min[1]+'a'));
                pq.offer(new int[]{min[0]+1,min[1]});
            }
        }
        for (int i=0;i< sc.length;i++){
            if (sc[i]=='?'){
                sc[i]=charpq.poll();
            }
        }
        return String.valueOf(sc);
    }
}
