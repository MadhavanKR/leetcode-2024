package com.mk.leetcode.dynamic_programming.two_dimensional;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/minimum-path-sum">Minimum Path Sum</a>
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] memo = new int[m+1][n+1];
        for (int i = 0; i <= m; i++)
            memo[i][n] = Integer.MAX_VALUE;
        for (int j = 0; j <= n; j++)
            memo[m][j] = Integer.MAX_VALUE;

        memo[m-1][n-1] = grid[m-1][n-1];

        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (i == m-1 && j == n-1)
                    continue;
                memo[i][j] = grid[i][j] + Math.min(memo[i+1][j], memo[i][j+1]);
            }
        }
//        printMatrix(grid, "Grid");
//        printMatrix(memo, "Memo");
        return memo[0][0];
    }

    public void printMatrix(int[][] matrix, String matrixName) {
        System.out.println(matrixName);
        for (int[] ints : matrix) System.out.println(Arrays.toString(ints));
    }

    public static void main(String[] args) {
        MinimumPathSum obj = new MinimumPathSum();
        System.out.println(obj.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
        System.out.println(obj.minPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}}));
    }
}
