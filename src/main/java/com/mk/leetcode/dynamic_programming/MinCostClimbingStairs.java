package com.mk.leetcode.dynamic_programming;

import java.util.Arrays;
import java.util.Collections;

/**
 * <a href="https://leetcode.com/problems/min-cost-climbing-stairs">Min Cost Climbing Stairs</a>
 */
public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] memo = new int[n];
        memo[0] = cost[0];
        memo[1] = cost[1];

        for (int i=2; i<n;i++)
            memo[i] = Math.min(memo[i-1], memo[i-2]) + cost[i];

        return Math.min(memo[n-1], memo[n-2]);
    }

    public static void main(String[] args) {
        MinCostClimbingStairs sol = new MinCostClimbingStairs();
        System.out.println(sol.minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
    }
}
