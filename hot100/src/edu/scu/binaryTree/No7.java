package edu.scu.binaryTree;

import java.util.Arrays;

public class No7 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return newFunc(nums,0,nums.length);
    }
    private TreeNode newFunc(int[] nums,int start,int end){
        if (start >= end) return null;
        int mid = (start+end)>>1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left=newFunc(nums,start,mid);
        root.right=newFunc(nums,mid+1,end);
        return root;
    }
}
