package edu.scu.stack;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack;
    int min;
    public MinStack() {
        stack=new Stack<>();
        min=Integer.MAX_VALUE;
    }

    public void push(int val) {
        if(val<=min&&!stack.isEmpty()){
            stack.push(min);
            min=val;
        }
        if(stack.isEmpty()){
            min=val;
        }
        stack.push(val);
    }

    public void pop() {
        int v=stack.pop();
        if(v==min){
            if(stack.isEmpty())min=Integer.MAX_VALUE;
            else{
                min=top();
                stack.pop();
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
