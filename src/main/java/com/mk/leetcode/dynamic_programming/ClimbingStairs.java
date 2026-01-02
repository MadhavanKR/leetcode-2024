package com.mk.leetcode.dynamic_programming;

/**
 * <a href="https://leetcode.com/problems/climbing-stairs/description">Climbing Stairs</a>
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n <= 1)
            return 1;
        if (n == 2)
            return 2;
        int[] memo = new int[n+1];
        memo[1] = 1;
        memo[2] = 2;
        for (int i = 3; i <= n; i++)
            memo[i] = memo[i-1] + memo[i-2];

        return memo[n];
    }

    public static void main(String[] args) {
        ClimbingStairs cs = new ClimbingStairs();
        System.out.println(cs.climbStairs(4));
    }
}
