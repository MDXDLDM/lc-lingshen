package edu.scu.myheap;

import java.util.TreeSet;

public class SeatManager {
    TreeSet<Integer> seats;
    public SeatManager(int n) {
        seats=new TreeSet<>();
        for (int i = 0; i < n; i++) {
            seats.add(i+1);
        }
    }

    public int reserve() {
        if (!seats.isEmpty()) {
            return seats.pollFirst();
        }
        return 0;
    }

    public void unreserve(int seatNumber) {
        seats.add(seatNumber);
    }
}
