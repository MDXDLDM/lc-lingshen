package edu.scu.binaryTree;

import java.util.Stack;

public class No9 {
    public int kthSmallest(TreeNode root, int k) {
        int count=0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root!=null||!stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            count++;
            if(count==k){
                return root.val;
            }
            root = root.right;
        }
        return -1;
    }
}
