package edu.scu.array;

import java.util.Stack;

public class No3 {
    public void rotate(int[] nums, int k) {
//        int len = nums.length;
//        k = k % len;
//        //Stack<Integer> stack = new Stack<Integer>();
//        int[] stack=new int[k];
//        for(int i=len-1;i>=len-k;i--){
//            //stack.push(nums[i]);
//            stack[len-i-1]=nums[i];
//        }
//        for(int i=len-1;i>=k;i--){
//            nums[i]=nums[i-k];
//        }
//        for(int i=0;i<k;i++){
//            //nums[i]=stack.pop();
//            nums[i]=stack[k-i-1];
//        }
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    private void reverse(int[] nums,int start,int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}
