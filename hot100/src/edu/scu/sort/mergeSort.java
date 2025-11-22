package edu.scu.sort;

import java.util.Arrays;

public class mergeSort {
    public static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        mergeDeepSort(arr,temp,0,arr.length-1);
    }
    private static void mergeDeepSort(int[] arr, int[] temp, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left+(right-left>>1);
        mergeDeepSort(arr,temp,left,mid);
        mergeDeepSort(arr,temp,mid+1,right);
        mergeCombine(arr,temp,left,mid,right);
    }
    private static void mergeCombine(int[] arr, int[] temp,int start,int mid,int end) {
        int start1=mid+1;
        int index=start;
        int begin=start;
        while(start <= mid && start1 <= end ) {
            temp[index++] = arr[start]<arr[start1]?arr[start++]:arr[start1++];
        }
        while(start<=mid){
            temp[index++] = arr[start++];
        }
        while(start1<=end){
            temp[index++] = arr[start1++];
        }
        for(int i=begin;i<=end;i++){
            arr[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] arr=new int[]{10,9,8,7,6,5,4,3,2,1};
        mergeSort.mergeSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
