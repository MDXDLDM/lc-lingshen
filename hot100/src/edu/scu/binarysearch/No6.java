package edu.scu.binarysearch;

public class No6 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size=nums1.length+nums2.length;
        return (findInCutting(nums1,nums2,0,0,(size>>1)+1)+findInCutting(nums1,nums2,0,0,((size-1)>>1)+1))/2.0;
    }
    private int findInCutting(int[] nums1,int[] nums2,int index1,int index2,int k){
        if(index1==nums1.length){
            return nums2[index2+k-1];
        }
        if(index2==nums2.length){
            return nums1[index1+k-1];
        }
        if(k==1){
            return Math.min(nums1[index1],nums2[index2]);
        }
        int lastindex1=Math.min(index1-1+(k>>1),nums1.length-1);
        int lastindex2=Math.min(index2-1+(k>>1),nums2.length-1);
        int a=nums1[lastindex1];
        int b=nums2[lastindex2];
        if(a>b){
            return findInCutting(nums1,nums2,index1,lastindex2+1,k-(lastindex2-index2+1));
        }else{
            return findInCutting(nums1,nums2,lastindex1+1,index2,k-(lastindex1-index1+1));
        }
    }
}
