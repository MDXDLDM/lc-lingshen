package edu.scu.backward;

import java.util.ArrayList;
import java.util.List;

public class No2 {
    List<List<Integer>> list=new ArrayList<>();
    List<Integer> path=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums,0);
        return list;
    }
    private void dfs(int[] nums,int index){
        list.add(new ArrayList<>(path));
        for(int i=index;i<nums.length;i++){
            path.add(nums[i]);
            dfs(nums,i+1);
            path.remove(path.size()-1);
        }
    }
}
