package com.mk.leetcode.dynamic_programming.longest_increasing_subseqence;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/longest-arithmetic-subsequence">Longest Arithmetic Subsequence</a>
 */
public class LongestArithmeticSubsequence {

    public int longestArithSeqLength(int[] nums) {
        Map<String, Integer> memo = new HashMap<>();

        int n = nums.length;
        int ans = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                int diff = nums[j] - nums[i];
                String iKey = i + "~" + diff;
                String jKey = j + "~" + diff;
                int res = Math.max(memo.getOrDefault(iKey, 1), 1 + memo.getOrDefault(jKey, 1));
                memo.put(iKey, res);
                ans = Math.max(ans, res);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestArithmeticSubsequence sol = new LongestArithmeticSubsequence();
        System.out.println(sol.longestArithSeqLength(new int[]{3, 6, 9, 12}));
        System.out.println(sol.longestArithSeqLength(new int[]{9, 4, 7, 2, 10}));
        System.out.println(sol.longestArithSeqLength(new int[]{20, 1, 15, 3, 10, 5, 8}));
    }
}
