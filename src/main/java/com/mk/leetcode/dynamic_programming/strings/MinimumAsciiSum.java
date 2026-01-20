package com.mk.leetcode.dynamic_programming.strings;

/**
 * <a href="https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings">Minimum ASCII Delete Sum for Two Strings</a>
 */
public class MinimumAsciiSum {

    public int minimumDeleteSum(String s1, String s2) {
        Integer[][] memo = new Integer[s1.length()][s2.length()];
        return minimumDeleteSumUtil(s1, s2, s1.length() - 1, s2.length() - 1, memo);
    }

    private int minimumDeleteSumUtil(String s1, String s2, int i, int j, Integer[][] memo) {
        if (i < 0) {
            int cost = 0;
            while (j >= 0)
                cost += s2.charAt(j--);
            return cost;
        }

        if (j < 0) {
            int cost = 0;
            while (i >= 0)
                cost += s1.charAt(i--);
            return cost;
        }

        if (memo[i][j] != null)
            return memo[i][j];

        if (s1.charAt(i) == s2.charAt(j))
            return minimumDeleteSumUtil(s1, s2, i - 1, j - 1, memo);

        int deleteFromS1 = s1.charAt(i) + minimumDeleteSumUtil(s1, s2, i - 1, j, memo);
        int deleteFromS2 = s2.charAt(j) + minimumDeleteSumUtil(s1, s2, i, j - 1, memo);
        int deleteFromBoth = s1.charAt(i) + s2.charAt(j) + minimumDeleteSumUtil(s1, s2, i - 1, j - 1, memo);
        return memo[i][j] = Math.min(deleteFromS1, Math.min(deleteFromS2, deleteFromBoth));
    }

    public static void main(String[] args) {
        MinimumAsciiSum m = new MinimumAsciiSum();
        System.out.println(m.minimumDeleteSum("sea", "eat"));
        System.out.println(m.minimumDeleteSum("delete", "leet"));
    }
}
