package edu.scu.easy;

public class No1287 {
    public int findSpecialInteger(int[] arr) {
        //连续相同的数超过25%(即至少为26%)，那么在下标为0+25,0+25+25+1,0+25+25+1+25处一定会有一处出现鱼
        int len=arr.length;
        int gap=len>>2;
        int index=gap;
        while(index<len){
            int num=arr[index];
            int start=getstart(arr,num);
            int end=getstart(arr,num+1);
            if(end-start>gap){
                return num;
            }
            index+=gap;
            index++;
        }
        return -1;
    }
    private int getstart(int[] arr,int target){
        int firstindex=0;
        int lastindex=arr.length-1;
        while(firstindex<=lastindex){
            int mid=firstindex+(lastindex-firstindex>>1);
            if(arr[mid]>=target){
                lastindex=mid-1;
            }else{
                firstindex=mid+1;
            }
        }
        return firstindex;
    }
}
