package edu.scu.part1;

public class No2321 {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int sum1=0;int sum2=0;
        for (int i=0;i<nums1.length;i++){
            sum1+=nums1[i];sum2+=nums2[i];
            nums1[i]=nums1[i]-nums2[i];
        }
        int min=0;
        int max=0;
        int maxf=0;int minf=0;
        for (int i=0;i<nums1.length;i++){
            if (maxf<0){
                maxf=nums1[i];
            }else{
                maxf+=nums1[i];
            }
            if (minf>0){
                minf=nums1[i];
            }else{
                minf+=nums1[i];
            }
            min=Math.min(min,minf);
            max=Math.max(max,maxf);
        }
        return Math.max(sum1-min,sum2+max);
    }
}
