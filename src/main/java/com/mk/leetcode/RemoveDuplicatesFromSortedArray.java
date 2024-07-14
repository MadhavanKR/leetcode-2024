package com.mk.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {0,0,1,1,1,2,2,3,3,4};

        int answer = solution.removeDuplicates(nums);
        System.out.printf("answer = %d\n", answer);
    }

    static class Solution {
        public int removeDuplicates(int[] nums) {

            if (nums.length == 0)
                return 0;

            int slow = 1;
            int fast = 1;

            while (fast < nums.length) {
                if (nums[fast] != nums[fast-1]) {
                    nums[slow] = nums[fast];
                    slow++;
                }
                fast++;
            }
            return slow;
        }
    }
}
