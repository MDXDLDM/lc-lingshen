package edu.scu.mid;

public class No1423 {
    public int maxScore(int[] cardPoints, int k) {
        int firstindex=k-1;int lastindex=cardPoints.length-1;
        int sum=0;int max=0;
        for(int i=0;i<k;i++){
            sum+=cardPoints[i];
            max=sum;
        }
        while(firstindex>=0){
            sum-=cardPoints[firstindex];
            sum+=cardPoints[lastindex];
            firstindex--;
            lastindex--;
            max=Math.max(max,sum);
        }
        return max;
    }
}
