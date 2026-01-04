package com.mk.leetcode.dynamic_programming.two_dimensional;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/unique-paths-ii">Unique Paths II</a>
 */
public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] memo = new int[m+1][n+1];
        memo[m-1][n-1] = 1;
        if (obstacleGrid[m-1][n-1] == 1)
            return 0;
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if ((i == m-1 && j == n-1) || obstacleGrid[i][j] == 1)
                    continue;
                memo[i][j] = memo[i+1][j] + memo[i][j+1];
            }
        }
        return memo[0][0];
    }

    public void printMatrix(int[][] matrix, String matrixName) {
        System.out.println(matrixName);
        for (int[] ints : matrix) System.out.println(Arrays.toString(ints));
    }

    public static void main(String[] args) {
        UniquePathsII uniquePathsII = new UniquePathsII();
        System.out.println(uniquePathsII.uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
        System.out.println(uniquePathsII.uniquePathsWithObstacles(new int[][]{{0, 1}, {0, 0}}));
    }
}
