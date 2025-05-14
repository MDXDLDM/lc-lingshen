package edu.scu.monotonicStack;

import java.util.Stack;

public class StockSpanner {
    Stack<int[]> stock;
    public StockSpanner() {
        stock = new Stack<>();
    }

    public int next(int price) {
        int count=1;
        while(!stock.isEmpty()&&price >= stock.peek()[0]) {
            int[] temp = stock.pop();
            count+=temp[1];
        }
        stock.push(new int[]{price,count});
        return count;
    }
}
