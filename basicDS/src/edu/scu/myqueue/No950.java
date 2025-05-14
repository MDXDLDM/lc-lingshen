package edu.scu.myqueue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class No950 {
    public int[] deckRevealedIncreasing(int[] deck) {
//        int[] res = new int[deck.length];
//        Arrays.sort(deck);
//        int index=0;
//        int len=res.length;
//        for(int i=0;index< len;i+=2){
//            res[i%len]=deck[index++];
//        }
//        //index=deck.length-1;
//        return res;
        int[] res = new int[deck.length];
        Arrays.sort(deck);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < deck.length; i++) {
            q.add(i);
        }
        int index=0;
        while (!q.isEmpty()) {
            res[q.poll()]=index;
            if (!q.isEmpty())q.add(q.poll());
            index++;
        }
        for (int i = 0; i < res.length; i++) {
            res[i]=deck[res[i]];
        }
        return res;
    }
}
