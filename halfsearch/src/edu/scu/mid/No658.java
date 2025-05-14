package edu.scu.mid;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class No658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new LinkedList<>();
        int l=findstart(arr,x);
        int r=l-1;
        int count=0;
        while(count!=k){
            if(r==-1){
                res.add(res.size(),arr[l++]);
            }else if(l==arr.length){
                res.add(0,arr[r--]);
            }else{
                if(x-arr[r]<=arr[l]-x){
                    res.add(0,arr[r--]);
                }else{
                    res.add(res.size(), arr[l++]);
                }
            }
            count++;
        }
        return res;
    }
    private int findstart(int[] arr, int x) {
        int startindex=0;
        int lastindex=arr.length-1;
        while(startindex<=lastindex){
            int mid=startindex+(lastindex-startindex>>1);
            if(arr[mid]>=x){
                lastindex=mid-1;
            }else{
                startindex=mid+1;
            }
        }
        return startindex;
    }
}
