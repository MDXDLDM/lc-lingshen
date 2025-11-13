package edu.scu.binaryTree;

public class No11 {
    //还有分治法
    TreeNode dummy = null;
    public void flatten(TreeNode root) {
        dfs(root);
    }
    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right);
        dfs(root.left);
        root.right=dummy;
        root.left=null;
        dummy=root;
    }
}
