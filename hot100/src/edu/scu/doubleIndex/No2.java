package edu.scu.doubleIndex;

public class No2 {
    public int maxArea(int[] height) {
        int firstindex=0;
        int lastindex=height.length-1;
        int res=(height.length-1)*Math.min(height[firstindex],height[lastindex]);
        //int res=0;
        while(firstindex<lastindex){
            int are=(lastindex-firstindex)*Math.min(height[firstindex],height[lastindex]);
            //int pre=Math.min(height[firstindex],height[lastindex]);
            if(height[firstindex]<height[lastindex]){
                firstindex++;
            }else{
                lastindex--;
            }
            res=Math.max(res,are);
        }
        return res;
    }
}
