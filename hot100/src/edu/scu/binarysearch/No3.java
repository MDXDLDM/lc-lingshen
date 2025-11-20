package edu.scu.binarysearch;

public class No3 {
    public int[] searchRange(int[] nums, int target) {
        int right=binarySearch(nums, target+1);
        int left=binarySearch(nums, target-1);
        if (left>right||nums[left]!=target) return new int[]{-1,-1};
        return new int[]{left,right};
    }
    private int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left>>1);
            if (nums[mid] <= target) {
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }
}
