package com.mk.leetcode;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/?envType=study-plan-v2&envId=top-interview-150
 */
public class RemoveDuplicatedSortedArray2 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = {0,0,1,1,1,1,2,2,2,4};
        int answer = solution.removeDuplicates(input);
        System.out.printf("answer = %d\n", answer);
    }

    static class Solution {
        public int removeDuplicates(int[] nums) {

            if (nums.length <= 2)
                return nums.length;

            int slow = 2;
            int fast = 2;

            while (fast < nums.length) {
                if (nums[fast] != nums[slow - 2])
                    nums[slow++] = nums[fast++];
                else
                    fast++;
            }

            return slow;
        }
    }

}
