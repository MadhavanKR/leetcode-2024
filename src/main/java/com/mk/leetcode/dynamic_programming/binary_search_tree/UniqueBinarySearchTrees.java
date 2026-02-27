package com.mk.leetcode.dynamic_programming.binary_search_tree;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/unique-binary-search-trees">Unique Binary Search Trees</a>
 */
public class UniqueBinarySearchTrees {

    public int numTrees(int n) {
        Map<String, Integer> memo = new HashMap<>();
        return numTreesUtil(1, n, memo);
    }

    public int numTreesUtil(int m, int n, Map<String, Integer> memo) {

        if (m >= n)
            return 1;
        String key = m + "~" + n;
        if (memo.containsKey(key))
            return memo.get(key);

        int res = 0;
        for (int i = m; i <= n; i++)
            res = res + (numTreesUtil(m, i - 1, memo) * numTreesUtil(i + 1, n, memo));
        memo.put(key, res);
        return res;
    }

    public static void main(String[] args) {
        UniqueBinarySearchTrees sol = new UniqueBinarySearchTrees();
        System.out.println(sol.numTrees(3));
        System.out.println(sol.numTrees(1));
        System.out.println(sol.numTrees(4));
    }
}
