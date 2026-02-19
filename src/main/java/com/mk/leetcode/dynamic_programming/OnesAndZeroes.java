package com.mk.leetcode.dynamic_programming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/ones-and-zeroes">Ones And Zeroes</a>
 */
public class OnesAndZeroes {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] pairs = new int[strs.length][2];
        for (int i = 0; i < strs.length; i++) {
            pairs[i][0] = pairs[i][1] = 0;
            for (char ch : strs[i].toCharArray()) {
                if (ch == '0')
                    pairs[i][0] += 1;
                else
                    pairs[i][1] += 1;
            }
        }

        Map<String, Integer> memo = new HashMap<>();
        int answer = findMaxFromUtil(pairs, pairs.length - 1, m, n, memo);
//        System.out.println("Memo = " + memo);
        return answer;
    }

    private int findMaxFromUtil(int[][] pairs, int i, int m, int n, Map<String, Integer> memo) {
        if (i < 0)
            return 0;

        String key = i + "~" + m + "~" + n;
        if (memo.containsKey(key))
            return memo.get(key);

        if (m - pairs[i][0] < 0 || n - pairs[i][1] < 0) {
            int res = findMaxFromUtil(pairs, i - 1, m, n, memo);
            memo.put(key, res);
            return res;
        } else {
            int including = 1 + findMaxFromUtil(pairs, i - 1, m - pairs[i][0], n - pairs[i][1], memo);
            int excluding = findMaxFromUtil(pairs, i - 1, m, n, memo);
            int res = Math.max(including, excluding);
            memo.put(key, res);
            return res;
        }
    }

    public static void main(String[] args) {
        OnesAndZeroes onesAndZeroes = new OnesAndZeroes();
        System.out.println(onesAndZeroes.findMaxForm(new String[]{"10","0001","111001","1","0"}, 5, 3));
        System.out.println(onesAndZeroes.findMaxForm(new String[]{"10","0","1"}, 1, 1));
        System.out.println(onesAndZeroes.findMaxForm(new String[]{"10","0001","111001","1","0"}, 4, 3));
        System.out.println(onesAndZeroes.findMaxForm(new String[]{"00011","00001","00001","0011","111"}, 8, 5));
    }
}
