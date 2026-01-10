package com.mk.leetcode.dynamic_programming.strings;

/**
 * <a href="https://leetcode.com/problems/longest-palindromic-substring">Longest Palindromic Substring</a>
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] memo = new boolean[n][n];
        int palindromeStart = 0;
        int palindromeEnd = 0;
        // base cases
        for (int i = 0; i < n; i++) {
            memo[i][i] = true;
            if (i + 1 < n && s.charAt(i) == s.charAt(i + 1)) {
                memo[i][i + 1] = true;
                palindromeStart = i;
                palindromeEnd = i + 1;
            }
        }

        // generic case
        for (int psLen = 2; psLen < n; psLen++) {
            for (int i = 0; i < n - psLen; i++) {
                int j =  i + psLen;
                if ((s.charAt(i) == s.charAt(j)) && memo[i+1][j-1]){
                    memo[i][j] = true;
                    palindromeStart = i;
                    palindromeEnd = j;
                }
            }
        }

        return s.substring(palindromeStart, palindromeEnd + 1);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring lp = new LongestPalindromicSubstring();
        System.out.println(lp.longestPalindrome("babad"));
        System.out.println(lp.longestPalindrome("cbbd"));
    }
}
