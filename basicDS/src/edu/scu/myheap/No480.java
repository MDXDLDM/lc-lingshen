package edu.scu.myheap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class No480 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> first=new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> second=new PriorityQueue<>();
        double[] result=new double[nums.length-k+1];
        boolean flag=k%2==0;//t-偶
        int firstindex=0;
        int lastindex=0;
        while(lastindex<k){
            second.add(nums[lastindex]);
            lastindex++;
        }
        while(first.size()<second.size()){
            first.add(second.poll());
        }
        if (flag){
            result[firstindex]=((double)first.peek()+second.peek())/2;
        }else{
            result[firstindex]=(double)first.peek();
        }
        while(lastindex<nums.length){
            System.out.println(first.peek());
            int value=nums[firstindex];
            if (value>first.peek()){
                second.remove(value);
                second.add(first.poll());
            }else{
                first.remove(value);
            }
            firstindex++;
            if (nums[lastindex]<=first.peek()){
                first.add(nums[lastindex]);
            }else{
                second.add(nums[lastindex]);
            }
            while(first.size()<second.size()){
                first.add(second.poll());
            }
            lastindex++;
            if (flag){
                result[firstindex]=((double)first.peek()+second.peek())/2;
            }else{
                result[firstindex]=(double)first.peek();
            }
        }
        return result;
    }
}
