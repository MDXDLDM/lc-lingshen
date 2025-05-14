package edu.scu.monotonicStack;

import java.util.Stack;

public class No503 {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<Integer>();
        int len= nums.length*2-1;
        for(int i=len;i>=0;i--){
            int index=i%nums.length;
            while(!stack.isEmpty() && nums[index]>=stack.peek()){
                stack.pop();
            }
            res[index]=stack.isEmpty()?-1:stack.peek();
            stack.push(nums[index]);
        }
        return res;
    }
}
