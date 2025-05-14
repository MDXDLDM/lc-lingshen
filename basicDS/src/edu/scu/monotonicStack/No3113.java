package edu.scu.monotonicStack;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;

public class No3113 {
    public long numberOfSubarrays(int[] nums) {
        //long res = 0;
//        HashMap<Integer,Integer> stack=new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            int num = nums[i];
//            Iterator<Integer> it = stack.keySet().iterator();
//            while (it.hasNext()) {
//                int key = it.next();
//                if (key == num){
//                    int value = stack.get(num);
//                    res+=value;
//                    stack.put(num,value+1);
//                }else if (num>key){
//                    it.remove();
//                }
//            }
//            if (!stack.containsKey(num)){
//                stack.put(num,1);
//            }
//        }
//        return res+nums.length;
        long res=nums.length;
        Stack<Integer> stack=new Stack<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            int num=nums[i];
            while(!stack.isEmpty() && stack.peek()<num){
                int key=stack.pop();
                map.remove(key);
            }
            if (map.containsKey(num)){
                int count=map.get(num);
                res+=count;
                map.put(num,count+1);
            }else{
                map.put(num,1);
            }
            stack.push(num);
        }
        return res;
    }
}
