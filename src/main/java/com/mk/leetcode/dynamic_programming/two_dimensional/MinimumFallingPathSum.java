package com.mk.leetcode.dynamic_programming.two_dimensional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/minimum-falling-path-sum">Minimum Falling Path Sum</a>
 */
public class MinimumFallingPathSum {

    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memo = new int[m][n];

        System.arraycopy(matrix[0], 0, memo[0], 0, n);

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = memo[i - 1][j];
                if (j - 1 >= 0)
                    memo[i][j] = Math.min(memo[i - 1][j - 1], memo[i][j]);
                if (j + 1 < n)
                    memo[i][j] = Math.min(memo[i - 1][j + 1], memo[i][j]);
                memo[i][j] += matrix[i][j];
            }
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++)
            min = Math.min(min, memo[m - 1][j]);
        return min;
    }

    public static void main(String[] args) {
        MinimumFallingPathSum obj = new MinimumFallingPathSum();
        System.out.println(obj.minFallingPathSum(new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}}));
        System.out.println(obj.minFallingPathSum(new int[][]{{-19, 57}, {-40, -5}}));
    }
}
