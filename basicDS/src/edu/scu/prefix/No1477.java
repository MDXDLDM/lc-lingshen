package edu.scu.prefix;

import java.util.HashMap;

public class No1477 {
    public int minSumOfLengths(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> address = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            map.put(sum,i);
            sum += arr[i];
            if(map.containsKey(sum-target)){
                address.put(map.get(sum-target),i);//start end
            }
        }
        //map.put(sum,arr.length);
        //int count=0;
        int res=Integer.MAX_VALUE;
//        for(int start:address.keySet()){
//            int end=address.get(start);
//            for(int otherkey:address.keySet()){
//                if(otherkey<=end)continue;
//                res=Math.min(res,address.get(otherkey)-otherkey+end-start+2);
//            }
//        }
//        return res==Integer.MAX_VALUE?-1:res;
        int[] postmin=new int[arr.length];
        int min=0;
        for (int i = postmin.length - 1; i >= 0; i--) {
            postmin[i]=min;//不包含当前下标的右侧
            if(address.containsKey(i)){
                min=min==0?address.get(i)-i+1:Math.min(min,address.get(i)-i+1);
            }
        }
        for(int start:address.keySet()){
            int end=address.get(start);
            if(postmin[end]==0)continue;
            res=Math.min(res,end-start+postmin[end]+1);
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
}
