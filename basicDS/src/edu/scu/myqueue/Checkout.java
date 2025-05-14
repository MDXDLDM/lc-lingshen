package edu.scu.myqueue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Checkout {
    PriorityQueue<Integer> pq;
    Queue<Integer> q;
    public Checkout() {
        pq=new PriorityQueue<>((p,q)->q-p);
        q=new LinkedList<>();
    }

    public int get_max() {
        if (pq.isEmpty()) return -1;
        return pq.peek();
    }

    public void add(int value) {
        pq.add(value);
        q.add(value);
    }

    public int remove() {
        if (q.isEmpty()) return -1;
        int value=q.poll();
        pq.remove(value);
        return value;
    }
}
