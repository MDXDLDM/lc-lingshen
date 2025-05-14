package edu.scu.myenum;

import java.util.HashSet;

public class No2260 {
    public int minimumCardPickup(int[] cards) {
        int firstindex=0;int lastindex=0;
        HashSet<Integer> set=new HashSet<>();
        int min=cards.length+1;
        while(lastindex<cards.length){
            if(set.contains(cards[lastindex])){
                while(cards[firstindex]!=cards[lastindex]){
                    set.remove(cards[firstindex]);
                    firstindex++;
                }
                min=Math.min(min,lastindex-firstindex+1);
                firstindex++;
            }
            set.add(cards[lastindex]);
            lastindex++;
        }
        return min==cards.length+1 ? -1 : min;
    }
}
