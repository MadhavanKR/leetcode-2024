package com.mk.leetcode.dynamic_programming.strings;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/longest-palindromic-subsequence">Longest Palindromic Subsequence</a>
 */
public class LongestPalindromicSubsequence {

    public int longestPalindromeSubseq(String s) {
        Integer[][] memo = new Integer[s.length()][s.length()];
        return lpsUtil(s, 0, s.length() - 1, memo);
    }

    public int lpsUtil(String s, int start, int end, Integer[][] memo) {
        if (start > end)
            return 0;

        if (memo[start][end] != null)
            return memo[start][end];

        if (start == end)
            return 1;

        if (s.charAt(start) == s.charAt(end))
            return memo[start][end] = 2 +  lpsUtil(s, start + 1, end - 1, memo);
        else
            return memo[start][end] = Math.max(lpsUtil(s, start+1, end, memo), lpsUtil(s, start, end - 1, memo));
    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
        System.out.println(lps.longestPalindromeSubseq("bbbab"));
        System.out.println(lps.longestPalindromeSubseq("cbbd"));
    }

}
