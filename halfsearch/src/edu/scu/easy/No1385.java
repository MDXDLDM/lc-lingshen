package edu.scu.easy;

import java.util.Arrays;

public class No1385 {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int result=0;
        for(int key : arr1){
            result += judge(key,arr2,d)?1:0;
        }
        return result;
    }
    private boolean judge(int key,int[] arr,int d){
        int firstindex=0;int lastindex=arr.length-1;//左闭右闭
        while(firstindex<=lastindex){
            int mid=firstindex+(lastindex-firstindex>>1);
            if(arr[mid]-key>d){
                lastindex=mid-1;
            }else if(key-arr[mid]>d){
                firstindex=mid+1;
            }else{
                return false;
            }
        }
        return true;
    }
}
