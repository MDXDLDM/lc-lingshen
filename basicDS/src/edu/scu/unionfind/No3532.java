package edu.scu.unionfind;

import java.util.HashMap;

public class No3532 {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
//        boolean[] res = new boolean[queries.length];
//        UnionFind uf = new UnionFind(nums[nums.length-1]);
//        for (int i = 0; i < queries.length; i++) {
//            for (int j=i+1; j<queries.length; j++) {
//                if (Math.abs(nums[i] - nums[j]) <= maxDiff) {
//                    uf.union(i, j);
//                }
//            }
//        }
//        for (int i = 0; i < queries.length; i++) {
//            int x = queries[i][0];
//            int y = queries[i][1];
//            res[i]=uf.isSame(x,y);
//        }
//        return res;
//        int lastindex=0;
//        boolean[] res = new boolean[queries.length];
//        HashMap<Integer,Integer> map = new HashMap<>();
//        for (int i=0;i<nums.length;i++){
//            int value = nums[i];
//            while(lastindex<nums.length&&nums[lastindex]-value<=maxDiff){
//                lastindex++;
//            }
//            map.put(i,lastindex);
//        }
//        int max=map.get(nums.length-1);
//        for(int i=nums.length-2;i>=0;i--){
//            if(map.get(i)>i+1){
//                map.put(i,max);
//            }else{
//                max=map.get(i);
//            }
//        }
//        for (int i=0;i<queries.length;i++){
//            int value = Math.min(queries[i][0],queries[i][1]);
//            int goal = Math.max(queries[i][0],queries[i][1]);
//            if (map.get(value)>goal){
//                res[i] = true;
//            }else{
//                res[i] = false;
//            }
//        }
//        return res;
            boolean[] res = new boolean[queries.length];
            int[] rank=new int[n];
            rank[0]=0;
            for (int i=1;i<n;i++){
                rank[i]=nums[i]-nums[i-1]<=maxDiff?rank[i-1]:rank[i-1]+1;
            }
            for (int i=0;i<queries.length;i++){
                res[i]=rank[queries[i][0]]==rank[queries[i][1]];
            }
            return res;
        }
}
