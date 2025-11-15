package edu.scu.backward;

import java.util.ArrayList;
import java.util.List;

public class No1 {
    List<List<Integer>> list=new ArrayList<>();
    List<Integer> path=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        dfs(nums,new boolean[nums.length]);
        return list;
    }
    private void dfs(int[] nums, boolean[] visited) {
        if (path.size() == nums.length) {
            list.add(new ArrayList<>(path));
            return;
        }
        for(int i=0; i<nums.length; i++) {
            if(!visited[i]){
                path.add(nums[i]);
                visited[i] = true;
                dfs(nums, visited);
                path.remove(path.size()-1);
                visited[i] = false;
            }
        }
    }
}
