package com.mk.leetcode.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/count-ways-to-build-good-strings">Count Ways to Build Good Strings</a>
 */
public class CountWaysToBuildGoodStrings {

    private static int MOD = 1000000007;

    public int countGoodStrings(int low, int high, int zero, int one) {
        Map<Integer, Integer> memo = new HashMap<>();
        return countGoodStringsUtil(0,  low, high, zero, one, memo);
    }

    private int countGoodStringsUtil(int len, int low, int high, int zero, int one, Map<Integer, Integer> memo) {
        if (len > high)
            return 0;

        if (memo.containsKey(len))
            return memo.get(len);

        int count = (len >= low) ? 1 : 0;

        int appendingZero = countGoodStringsUtil(len + zero, low, high, zero, one, memo);
        int appendingOne = countGoodStringsUtil(len + one, low, high, zero, one, memo);
        int result = (count + appendingZero + appendingOne) % MOD;
        memo.put(len, result);
        return result;
    }


    public static void main(String[] args) {
        CountWaysToBuildGoodStrings sol = new CountWaysToBuildGoodStrings();
        System.out.println(sol.countGoodStrings(3,3,1,1));
        System.out.println(sol.countGoodStrings(2,3,1,2));
    }
}
