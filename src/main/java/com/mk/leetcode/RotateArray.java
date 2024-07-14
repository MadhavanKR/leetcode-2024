package com.mk.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/rotate-array/?envType=study-plan-v2&envId=top-interview-150
 */
public class RotateArray {

    public static void main(String[] args) {
        int[] input = {1,2,3,4,5,6,7};
        int k = 3;
        Solution solution = new Solution();
        solution.rotate(input, k);
        System.out.printf("answer - %s", Arrays.toString(input));
    }

    static class Solution {
        public void rotate(int[] nums, int k) {
            k = k % nums.length;
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);
        }

        public void reverse(int[] nums, int start, int end) {
            while (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }

        }
    }

}
