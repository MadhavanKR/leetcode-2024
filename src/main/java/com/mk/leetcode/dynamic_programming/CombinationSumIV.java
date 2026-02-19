package com.mk.leetcode.dynamic_programming;

/**
 * <a href="https://leetcode.com/problems/combination-sum-iv">Combination Sum IV</a>
 */
public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        Integer[] memo = new Integer[target + 1];
        return combinationSumUtil(nums, target, memo);
    }

    private int combinationSumUtil(int[] nums, int target, Integer[] memo) {
        if (target == 0)
            return 1;

        if (target < 0)
            return 0;

        if (memo[target] != null)
            return memo[target];

        int res = 0;
        for (int num : nums) {
            res += combinationSumUtil(nums, target - num, memo);
        }
        return memo[target] = res;
    }

    public static void main(String[] args) {
        CombinationSumIV combinationSumIV = new CombinationSumIV();
        System.out.println(combinationSumIV.combinationSum4(new int[]{1, 2, 3}, 4));
        System.out.println(combinationSumIV.combinationSum4(new int[]{9}, 3));
    }
}
