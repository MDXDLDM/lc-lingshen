package edu.scu.binaryTree;

public class No15 {
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int leftMax=dfs(root.left);
        int rightMax=dfs(root.right);
        max=Math.max(max,root.val+leftMax+rightMax);
        return Math.max(Math.max(leftMax,rightMax)+root.val,0);
    }
}
