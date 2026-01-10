package com.mk.leetcode.dynamic_programming.two_dimensional;

import java.util.Arrays;

/**
 * <a href='https://leetcode.com/problems/maximal-square'>Maximal Square</a>
 */
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memo = new int[m][n];
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = (matrix[i][j] == '1' ? 1 : 0);
                maxArea = Math.max(maxArea, memo[i][j]);
            }
        }

//        printMatrix(memo, "Memo after initialization");
//        for (int j = 0; j < n; j++)
//            memo[0][j] = matrix[0][j] == '1' ? 1 : 0;


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1')
                    memo[i][j] = Math.min(memo[i - 1][j - 1], Math.min(memo[i - 1][j], memo[i][j - 1])) + 1;
                maxArea = Math.max(maxArea, memo[i][j]);
            }
        }
//        printMatrix(memo, "Memo after processing");
        return maxArea;
    }

    public void printMatrix(int[][] matrix, String matrixName) {
        System.out.println(matrixName);
        for (int[] ints : matrix) System.out.println(Arrays.toString(ints));
    }

    public static void main(String[] args) {
        MaximalSquare obj = new MaximalSquare();
        System.out.println(obj.maximalSquare(new char[][]{{'1','0','1','0','0'}, {'1','0','1','1','1'}, {'1','1','1','1','1'}, {'1','0','0','1','0'}}));
        System.out.println(obj.maximalSquare(new char[][]{{'0','1'}, {'1','0'}}));
        System.out.println(obj.maximalSquare(new char[][]{{'0'}}));
    }
}
