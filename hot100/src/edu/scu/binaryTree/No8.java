package edu.scu.binaryTree;

public class No8 {
    public boolean isValidBST(TreeNode root) {
        return newFunc(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean newFunc(TreeNode root,long min,long max) {
        boolean flag=true;
        if (root == null) return flag;
        if(root.val>min&&root.val<max){
            if (root.left != null) {
                flag&=newFunc(root.left,min,Math.min(root.val,max));
            }
            if (root.right != null) {
                flag&=newFunc(root.right,Math.max(root.val, min),max);
            }
        }else{
            flag=false;
        }
        return flag;
    }
}
