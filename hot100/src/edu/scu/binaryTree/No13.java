package edu.scu.binaryTree;

import java.util.HashMap;
import java.util.Map;

public class No13 {
    Map<Long,Integer> map=new HashMap<>();
    int res=0;
    public int pathSum(TreeNode root, int targetSum) {
        map.put(0L,1);
        dfs(root,targetSum,0L);
        return res;
    }
    private void dfs(TreeNode root,int sum,long presum) {
        if(root==null) return;
        presum+=root.val;
        res+=map.getOrDefault(presum-sum,0);
        map.put(presum,map.getOrDefault(presum,0) + 1);
        dfs(root.left,sum,presum);
        dfs(root.right,sum,presum);
        map.put(presum,map.getOrDefault(presum,0) - 1);
    }
}
