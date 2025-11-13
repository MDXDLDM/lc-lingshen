package edu.scu.binaryTree;

public class No12 {
    int preindex=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildeSubtree(preorder, inorder, 0, inorder.length);
    }
    private TreeNode buildeSubtree(int[] preorder, int[] inorder,int instart,int inend){
        if(instart>=inend) return null;
        int val = preorder[preindex];//中节点
        TreeNode root = new TreeNode(val);
        int index=0;
        for(int i=instart; i<inend; i++){
            if(inorder[i]==val){
                index=i;
            }
        }
        preindex++;//获取下个根
        if(instart+1==inend){
            return root;
        }
        root.left=buildeSubtree(preorder,inorder,instart,index);
        root.right=buildeSubtree(preorder,inorder,index+1,inend);
        return root;
    }
}
