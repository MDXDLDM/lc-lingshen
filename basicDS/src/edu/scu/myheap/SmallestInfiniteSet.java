package edu.scu.myheap;

import java.util.HashSet;
import java.util.PriorityQueue;

public class SmallestInfiniteSet {
    int index;//index用于模拟无线集合
    PriorityQueue<Integer> pq;//存储被移除过的元素
    public SmallestInfiniteSet() {
        index=1;
        pq=new PriorityQueue<>();
    }

    public int popSmallest() {
        System.out.println(index);
        if (pq.isEmpty()){
            pq.add(index);
            return index++;
        }
        else{
            while (pq.contains(index)){
                index++;
            }
            pq.add(index);
            return index++;
        }
    }

    public void addBack(int num) {
        if (pq.contains(num)){
            pq.remove(num);
            if (index>num){
                index=num;
            }
        }
    }
}
