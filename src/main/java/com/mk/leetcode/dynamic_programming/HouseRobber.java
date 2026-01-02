package com.mk.leetcode.dynamic_programming;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/house-robber">House Robber</a>
 */
public class HouseRobber {

    public int rob(int[] nums) {
        /**
         * memo stores the maximum money made robbing houses till given index i (from backward)
         * memo[n-1] is maximum money that can be made by robbing only last house
         * memo[n-2] is maximum money that can be made by robbing last two houses
         * memo[n-3] is maximum money that can be made by robbing last 3 houses and so on.
         * The same can be implemented from first house as well, in which case we invoke robUtil(nums, n-1, memo) and initialize memo[0] = nums[0]
         */
        int[] memo = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            memo[i] = -1;

        memo[nums.length - 1] = nums[nums.length - 1];
        robUtil(nums, 0, memo);
        return memo[0];
    }

    public int robUtil(int[] nums, int i, int[] memo) {
        if (i == nums.length)
            return 0;

        if (memo[i] != -1)
            return memo[i];

        int withRobbing = nums[i] + robUtil(nums, i + 2, memo);
        int withoutRobbing = robUtil(nums, i + 1, memo);
        memo[i] = Math.max(withRobbing, withoutRobbing);
        return memo[i];
    }

    public int robIterative(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        if (nums.length == 1)
            return nums[0];

        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);

        int[] memo = new int[nums.length];
        int n = nums.length;
        memo[n - 1] = nums[n - 1];
        memo[n - 2] = Math.max(nums[n - 2], nums[n - 1]);
        for (int i = n - 3; i >= 0; i--) {
            int withRobbing = nums[i] + memo[i + 2];
            int withoutRobbing = memo[i + 1];
            memo[i] = Math.max(withRobbing, withoutRobbing);
        }
        return memo[0];
    }

    public static void main(String[] args) {
        HouseRobber houseRobber = new HouseRobber();
        System.out.println(houseRobber.robIterative(new int[]{1, 2, 3, 1}));
        System.out.println(houseRobber.robIterative(new int[]{2, 7, 9, 3, 1}));
    }
}
