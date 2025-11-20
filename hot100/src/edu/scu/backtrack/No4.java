package edu.scu.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No4 {
    List<List<Integer>> list=new ArrayList<>();
    List<Integer> path=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates,target,0);
        return list;
    }
    private void dfs(int[] candidates, int target,int index) {
        if (target == 0) {
            list.add(new ArrayList<>(path));
            return;
        }
        for(int i=index; i<candidates.length; i++) {
            if(target-candidates[i]<0) {
                return;
            }
            path.add(candidates[i]);
            dfs(candidates,target-candidates[i],i);
            path.remove(path.size()-1);
        }
    }
}
