package edu.scu.part2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class No120 {
    public int minimumTotal(List<List<Integer>> triangle) {
//        List<List<Integer>> dp= new LinkedList<>();
//        List<Integer> newlist= new LinkedList<>();
//        int num=triangle.get(0).get(0);
//        if (triangle.size()==1){
//            return num;
//        }
//        newlist.add(num);
//        dp.add(newlist);
//        int min=Integer.MAX_VALUE;
//        for (int i = 1; i < triangle.size(); i++) {
//            List<Integer> temp= triangle.get(i);
//            List<Integer> newlist2= new LinkedList<>();
//            for (int j = 0; j < temp.size(); j++) {
//                int value;
//                if (j==temp.size()-1){
//                    value=dp.get(i-1).get(j-1);
//                }else{
//                    value= dp.get(i - 1).get(j);
//                }
//                if (j>=1){
//                    value=Math.min(value,dp.get(i - 1).get(j-1));
//                }
//                int addnum=value+temp.get(j);
//                newlist2.add(addnum);
//                if (i==triangle.size()-1){
//                    min=Math.min(min,addnum);
//                }
//            }
//            dp.add(newlist2);
//        }
//        return min;
        int[] dp = new int[triangle.size()];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            int len = triangle.get(i).size();
            for (int j=len-1;j>=0;j--){
                int value=triangle.get(i).get(j);
                if (j==0){
                    dp[j]+=value;
                }else if(j==len-1){
                    dp[j]=dp[j-1]+value;
                }else{
                    dp[j]=Math.min(dp[j-1],dp[j])+value;
                }
            }
        }
        int min=Integer.MAX_VALUE;
        for (int i=0;i<dp.length;i++){
            min=Math.min(min,dp[i]);
        }
        return min;
    }
}
