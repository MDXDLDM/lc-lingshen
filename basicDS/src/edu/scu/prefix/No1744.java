package edu.scu.prefix;

public class No1744 {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        boolean[] ans=new boolean[queries.length];
        long[] presum=new long[candiesCount.length];
        long sum=0;
        for (int i = 0; i < candiesCount.length; i++) {
            sum+=candiesCount[i];
            presum[i]=sum;
        }
        for (int i = 0; i < queries.length; i++) {
            int type=queries[i][0];
            int day=queries[i][1];
            int limit=queries[i][2];
            long can=(long)limit*(day+1);
            if(presum[type]>=can||day>=presum[type]+candiesCount[type]){
                ans[i]=false;
            }else{
                ans[i]=true;
            }
        }
        return ans;
    }
}
