package com.mk.leetcode.dynamic_programming.longest_increasing_subseqence;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference">Longest Arithmetic subsequence of Given Difference</a>
 */
public class LongestArithmeticSubsequenceOfDifference {

//    public int longestSubsequence(int[] arr, int difference) {
//        int n = arr.length;
//        int[] memo = new int[n];
//        Arrays.fill(memo, 1);
//
//        Map<Integer, List<Integer>> valuesToIndex = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            if (!valuesToIndex.containsKey(arr[i]))
//                valuesToIndex.put(arr[i], new ArrayList<>());
//            valuesToIndex.get(arr[i]).add(i);
//        }
//
//        int ans = 1;
//        for (int i = 0; i < n; i++) {
//            int adjacentNumber = arr[i] - difference;
//            for (int j : valuesToIndex.getOrDefault(adjacentNumber, Collections.emptyList())) {
//                if (j < i)
//                    memo[i] = Math.max(memo[i], memo[j] + 1);
//            }
//            ans = Math.max(ans, memo[i]);
//        }
//
//        return ans;
//    }

    public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        Map<Integer, Integer> memo = new HashMap();

        int ans = 1;
        for (int arrNum : arr) {
            int adjacentNumber = arrNum - difference;
            memo.put(arrNum, memo.getOrDefault(adjacentNumber, 0) + 1);
            ans = Math.max(ans, memo.get(arrNum));
        }

        return ans;
    }

    public static void main(String[] args) {
        LongestArithmeticSubsequenceOfDifference sol = new LongestArithmeticSubsequenceOfDifference();
        System.out.println(sol.longestSubsequence(new int[]{1, 2, 3, 4}, 1));
        System.out.println(sol.longestSubsequence(new int[]{1, 3, 5, 7}, 1));
        System.out.println(sol.longestSubsequence(new int[]{1, 5, 7, 8, 5, 3, 4, 2, 1}, -2));
    }
}
