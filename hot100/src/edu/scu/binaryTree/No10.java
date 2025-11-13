package edu.scu.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class No10 {
    private List<Integer> list = new ArrayList<Integer>();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 1);
        return list;
    }
    private void dfs(TreeNode root,int depth) {
        if (root == null) return;
        if (depth>list.size()){
            list.add(root.val);
        }
        dfs(root.right,depth+1);
        dfs(root.left,depth+1);
    }
}
