package com.mk.leetcode.dynamic_programming.two_dimensional;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/uncrossed-lines">Uncrossed Lines</a>
 */
public class UncrossedLines {

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[][] memo = new int[n][m];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            memo[i][0] = nums1[i] == nums2[0] ? 1 : 0;
            if (i > 0)
                memo[i][0] = Math.max(memo[i][0], memo[i - 1][0]);
            ans = Math.max(ans, memo[i][0]);
        }

        for (int j = 0; j < m; j++) {
            memo[0][j] = nums1[0] == nums2[j] ? 1 : 0;
            if (j > 0)
                memo[0][j] = Math.max(memo[0][j], memo[0][j - 1]);
            ans = Math.max(ans, memo[0][j]);
        }

//        printMatrix(memo, "Memo after initializing");

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (nums1[i] == nums2[j])
                    memo[i][j] = 1 + memo[i - 1][j - 1];
                else
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
                ans = Math.max(ans, memo[i][j]);
            }
        }

//        printMatrix(memo, "Memo after calculating");
        return ans;
    }

    public void printMatrix(int[][] matrix, String matrixName) {
        System.out.println(matrixName);
        for (int[] ints : matrix) System.out.println(Arrays.toString(ints));
    }


    public static void main(String[] args) {
        UncrossedLines sol = new UncrossedLines();
        System.out.println(sol.maxUncrossedLines(new int[]{1}, new int[]{1, 3}));
//        System.out.println(sol.maxUncrossedLines(new int[]{1, 4, 2}, new int[]{1, 2, 4}));
//        System.out.println(sol.maxUncrossedLines(new int[]{2, 5, 1, 2, 5}, new int[]{10, 5, 2, 1, 5, 2}));
//        System.out.println(sol.maxUncrossedLines(new int[]{1, 3, 7, 1, 7, 5}, new int[]{1, 9, 2, 5, 1}));
    }
}
