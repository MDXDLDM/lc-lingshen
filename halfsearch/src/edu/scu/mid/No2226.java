package edu.scu.mid;

public class No2226 {
    public int maximumCandies(int[] candies, long k) {
        long sum=0;
        for (int i = 0; i < candies.length; i++) {
            sum+=candies[i];
        }
        if(sum<k)return 0;
        int left=1;int right= (int) (sum/k);
        while(left<right){
            //左闭右闭
            int mid=left+(right-left>>1);
            long temp=0;
            for (int i = 0; i < candies.length; i++) {
                temp+=candies[i]/mid;
            }
            if(temp<k){
                //说明此时的分配过于多了，人不够分
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return right;
    }
}
