package edu.scu.sort;

import java.util.Arrays;

public class quickSort {
    public static void quickSort(int[] arr, int left, int right) {
        if(left>=right) return;
        int pivot = arr[left];
        int i = left;
        int j = right;
        while(left<right) {
            while(left<right && arr[right]>pivot) {
                right--;
            }
            if(left<right) {
                arr[left] = arr[right];
            }
            while(left<right && arr[left]<pivot) {
                left++;
            }
            if(left<right) {
                arr[right] = arr[left];
            }
            if(left==right){
                arr[left] = pivot;
            }
        }
        quickSort(arr, i, right-1);
        quickSort(arr, left+1, j);
    }

    public static void main(String[] args) {
        int[] arr=new int[]{10,9,8,7,6,5,4,3,2,1};
        quickSort.quickSort(arr,0,9);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
