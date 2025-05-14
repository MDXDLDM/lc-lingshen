package edu.scu.mystack;

public class No1006 {
    public int clumsy(int n) {
        int count=n;
        long temp=0;
        long res=0;
        while (count>0) {
            int index=n-count;
            if (index%4==0) {
                temp+=count;
            }else if (index%4==1) {
                temp*=count;
            }else if (index%4==2) {
                temp/=count;
            }else{
                res+=count;
                res+=n-count>3?temp:-temp;
                temp=0;
            }
            count--;
        }
        return n<3?(int)(res+temp):(int)(res-temp);
    }
}
