package com.mk.leetcode.dynamic_programming.longest_increasing_subseqence;

import java.util.Arrays;

public class NumberOfLongestIncreasingSubsequences {

    public int findNumberOfLIS(int[] nums) {
        Integer[] memo = new Integer[nums.length];
        Integer[] count = new Integer[nums.length];
        Arrays.fill(memo, 1);
        Arrays.fill(count, 1);
        int lisLength = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (memo[j] + 1 > memo[i]) {
                        count[i] = 0;
                        memo[i] = memo[j] + 1;
                    }
                    if (memo[j] + 1 == memo[i]) {
                        count[i] += count[j];
                    }
                }
            }
            if (memo[i] > lisLength) {
                lisLength = memo[i];
            }
        }
//        System.out.printf("LisLength = %d for Array %s and memo = %s and count = %s %n",  lisLength, Arrays.toString(nums), Arrays.toString(memo), Arrays.toString(count));
        int ans = 0;
        for (int lisIndex = 0; lisIndex < memo.length; lisIndex++) {
            if (lisLength == memo[lisIndex])
                ans += count[lisIndex];
        }
        return ans;
    }

    public static void main(String[] args) {
        NumberOfLongestIncreasingSubsequences sol = new NumberOfLongestIncreasingSubsequences();
        System.out.println(sol.findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
        System.out.println(sol.findNumberOfLIS(new int[]{2, 2, 2, 2, 2}));
        System.out.println(sol.findNumberOfLIS(new int[]{1, 2, 4, 3, 5, 4, 7, 2}));
    }
}
