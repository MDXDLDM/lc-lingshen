package edu.scu.myheap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class StockPrice {
    TreeMap<Integer,Integer> map;//time-price
    PriorityQueue<int[]> pq;
    PriorityQueue<int[]> pq2;
    public StockPrice() {
        map = new TreeMap<>(Comparator.reverseOrder());
        pq = new PriorityQueue<>((a,b)->b[1]-a[1]);
        pq2 = new PriorityQueue<>((a,b)->a[1]-b[1]);
    }

    public void update(int timestamp, int price) {
        map.put(timestamp,price);
        pq.add(new int[]{timestamp,price});
        pq2.add(new int[]{timestamp,price});
    }

    public int current() {
        return map.firstEntry().getValue();
    }

    public int maximum() {
        while(!pq.isEmpty()&&pq.peek()[1]!=map.get(pq.peek()[0])) {
            pq.poll();
        }
        if (!pq.isEmpty()) {
            return pq.peek()[1];
        }
        return -1;
    }

    public int minimum() {
        while(!pq2.isEmpty()&&pq2.peek()[1]!=map.get(pq2.peek()[0])) {
            pq2.poll();
        }
        if (!pq2.isEmpty()) {
            return pq2.peek()[1];
        }
        return -1;
    }
}
