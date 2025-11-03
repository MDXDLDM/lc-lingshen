package edu.scu.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class No1 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        //midOrderTraversal(root,list);
        //if (root == null) return list;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        //stack.push(root);
        while (root!=null||!stack.isEmpty()) {
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }
    //递归
    public void midOrderTraversal(TreeNode root,List<Integer> list) {
        if (root == null) return;
        if (root.left != null) {
            midOrderTraversal(root.left,list);
        }
        list.add(root.val);
        if (root.right != null) midOrderTraversal(root.right,list);
    }
}
