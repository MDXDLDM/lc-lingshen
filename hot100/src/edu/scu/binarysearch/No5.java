package edu.scu.binarysearch;

public class No5 {
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1; // 开区间 (-1, n-1)
        while (left < right) { // 开区间不为空
            int mid = (left + right) >> 1;
            if (nums[mid] < nums[n - 1]) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return nums[left];
    }
}
