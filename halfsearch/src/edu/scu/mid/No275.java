package edu.scu.mid;

public class No275 {
    public int hIndex(int[] citations) {
//        int max=0;
//        for (int i = 0; i < citations.length; i++) {
//            max=Math.max(max,citations[i]);
//        }
//        return getindex(citations,Math.max(citations.length, max));
        int left=-1;int right=citations.length+1;
        while(left+1<right){
            int mid=left+(right-left>>1);
            if(citations[citations.length-mid]>=mid){
                left=mid;
            }else{
                right=mid;
            }
        }
        return left;
    }
    private int getindex(int[] citations,int maxindex) {
        int left=-1;int right=maxindex+1;
        while (left<right-1) {
            int mid=left+(right-left>>1);
            if(citations[citations.length-mid]>=mid){
                //表明此时大于等于mid次引用的个数大于了mid，可以增大mid
                left=mid;
            }else{
                right=mid;
            }
        }
        return right;
    }
}
