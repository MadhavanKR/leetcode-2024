package com.mk.leetcode.dynamic_programming.two_dimensional;

/**
 * <a href="https://leetcode.com/problems/unique-paths">Unique Paths</a>
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m+1][n+1];
        for (int i = 0; i <= m; i++)
            memo[i][n] = 0;
        for (int j = 0; j <= n; j++)
            memo[m][j] = 0;

        memo[m-1][n-1] = 1;

        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (i == m-1 && j == n-1)
                    continue;
                memo[i][j] = memo[i+1][j] + memo[i][j+1];
            }
        }

        return memo[0][0];
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(3, 7));
        System.out.println(uniquePaths.uniquePaths(3, 2));
    }
}
