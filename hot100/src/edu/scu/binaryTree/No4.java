package edu.scu.binaryTree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class No4 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return Compare(root.left,root.right);
    }
    private boolean Compare(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 != null && root2 != null) {
            return Integer.compare(root1.val, root2.val) == 0&&Compare(root1.left, root2.right)&&Compare(root1.right, root2.left);
        }
        return false;
    }
}
