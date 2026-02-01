package com.mk.leetcode.dynamic_programming.longest_increasing_subseqence;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/longest-increasing-subsequence">Longest Common Subsequence</a>
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        Integer[] memo = new Integer[nums.length];
        Arrays.fill(memo, 1);
        int ans = Integer.MIN_VALUE;
        for (int i=0; i<nums.length; i++) {
            for (int j=0; j<i; j++) {
                if (nums[i] > nums[j])
                    memo[i] =  Math.max(memo[i], memo[j] + 1);
            }
            ans = Math.max(ans, memo[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence sol = new LongestIncreasingSubsequence();
        System.out.println(sol.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(sol.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        System.out.println(sol.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}));
        System.out.println(sol.lengthOfLIS(new int[]{4, 10, 4, 3, 8, 9}));
    }
}
