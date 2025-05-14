package edu.scu.monotonicStack;

import java.util.Stack;

public class No739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, temperatures[0]});
        for(int i=1;i<temperatures.length;i++){
            int value=temperatures[i];
            while(!stack.isEmpty()&&stack.peek()[1]<value){
                int[] temp=stack.pop();
                result[temp[0]]=i-temp[0];
            }
            stack.push(new int[]{i,temperatures[i]});
        }
        while(!stack.isEmpty()){
            int[] temp=stack.pop();
            result[temp[0]]=0;
        }
        return result;
    }
}
