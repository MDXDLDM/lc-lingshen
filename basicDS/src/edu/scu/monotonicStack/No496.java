package edu.scu.monotonicStack;

import java.util.HashMap;
import java.util.Stack;

public class No496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i= nums2.length-1; i>=0; i--){
            while(!stack.isEmpty() && nums2[i] >= stack.peek()){
                stack.pop();
            }
            map.put(nums2[i], stack.isEmpty()?-1:stack.peek());
            stack.push(nums2[i]);
        }
        int[] res = new int[nums1.length];
        for(int j=0; j<nums1.length; j++){
            res[j] = map.get(nums1[j]);
        }
        return res;
    }
}
