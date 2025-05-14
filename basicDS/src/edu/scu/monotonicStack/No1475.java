package edu.scu.monotonicStack;

import java.util.Stack;

public class No1475 {
    public int[] finalPrices(int[] prices) {
        int[] result = new int[prices.length];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i=prices.length-1; i>=0; i--) {
            while (!stack.isEmpty() && prices[i] < stack.peek()) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? prices[i]: prices[i]-stack.peek();
            stack.push(prices[i]);
        }
        return result;
    }
}
