package edu.scu.hard;

public class No878 {
    public int nthMagicalNumber(int n, int a, int b) {
        long left=0;long right=(long)Math.max(a,b)*n;
        int c=getMinEqual(Math.max(a,b),Math.min(a,b));
        while(left<=right){
            long mid=left+(right-left>>1);
            if(check(n,a,b,c,mid)){
                //代表此时mid比预期结果小
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return (int)(left%(1e9+7));
    }
    private boolean check(int n,int a,int b,int c,long value){
        long numa=value/a;
        long numb=value/b;
        long numc=value/c;
        return n-numa-numb+numc>0;
    }
    private int getMinEqual(int a,int b){
        int mul=a*b;
        while(a%b!=0){
            a%=b;
            int temp=a;
            a=b;
            b=temp;
        }
        return mul/b;
    }
}
