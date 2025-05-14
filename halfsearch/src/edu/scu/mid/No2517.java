package edu.scu.mid;

import java.util.Arrays;

public class No2517 {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int left=0;int right=price[price.length-1]-price[0];
        while(left<=right){
            int mid=left+(right-left>>1);
            if(check(price,k,mid)){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return right;
    }
    private boolean check(int[] price, int k, int top) {
        int temp=price[0];
        for (int i = 1; i < price.length; i++) {
            if(price[i]-temp>=top){
                temp=price[i];
                k--;
            }
        }
        return k<=1;
    }
}
