package com.mk.leetcode;

import java.util.Arrays;

public class RemoveElement {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {3, 2, 2, 3};
        int val = 3;

        int answer = solution.removeElement(nums, val);
        System.out.printf("answer = %d and nums = %s\n", answer, Arrays.toString(nums));
    }

    static class Solution {
        public int removeElement(int[] nums, int val) {

            // maintain two pointers left and right.
            // scan the array left to right.
            // Case-1: When you see the "val", ignore.
            // Case-2: When you see other than "val", copy it to nums[left] and update the left pointer
            // in both cases, update right pointer
            int left = 0;
            int right = 0;

            while (right < nums.length) {
                if (nums[right] != val) {
                    nums[left] = nums[right];
                    left++;
                }
                right++;
            }

            return left;

        }
    }
}
