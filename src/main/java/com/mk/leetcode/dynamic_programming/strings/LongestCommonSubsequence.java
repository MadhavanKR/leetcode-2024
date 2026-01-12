package com.mk.leetcode.dynamic_programming.strings;

/**
 * <a href="https://leetcode.com/problems/longest-common-subsequence">Longest Common Subsequence</a>
 */
public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        Integer[][] memo = new Integer[m][n];
//        lcsUtil(s1, s2, m-1, n-1, memo);
//        return memo[m-1][n-1];
        return lcsIterative(s1, s2);
    }

    public int lcsIterative(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        Integer[][] memo = new Integer[m+1][n+1];
        for (int i = 0; i <= m; i++)
            memo[i][n] = 0;

        for (int j = 0; j <= n; j++)
            memo[m][j] = 0;

        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j))
                    memo[i][j] = 1 + memo[i+1][j+1];
                else
                    memo[i][j] = Math.max(memo[i+1][j], memo[i][j+1]);
            }
        }

        return memo[0][0];
    }

    public int lcsUtil(String s1, String s2, int i, int j, Integer[][] memo) {
        if (i < 0 || j < 0)
            return 0;
        if (memo[i][j] != null)
            return memo[i][j];

        if (s1.charAt(i) == s2.charAt(j))
            return memo[i][j] = 1 + lcsUtil(s1, s2, i - 1, j - 1, memo);
        else
            return memo[i][j] = Math.max(lcsUtil(s1, s2, i - 1, j, memo), lcsUtil(s1, s2, i, j - 1, memo));
    }
    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        System.out.println(lcs.longestCommonSubsequence("abcde", "ace"));
        System.out.println(lcs.longestCommonSubsequence("abc", "abc"));
        System.out.println(lcs.longestCommonSubsequence("abc", "def"));
    }
}
