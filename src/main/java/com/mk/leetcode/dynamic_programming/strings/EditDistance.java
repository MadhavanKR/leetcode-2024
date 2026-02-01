package com.mk.leetcode.dynamic_programming.strings;

/**
 * <a href="https://leetcode.com/problems/edit-distance">Edit Distance</a>
 */
public class EditDistance {

    public int minDistance(String word1, String word2) {
        Integer[][] memo = new Integer[word1.length() + 1][word2.length() + 1];
        return minDistanceUtil(word1, word2, 0, 0, memo);
    }

    public int minDistanceUtil(String word1, String word2, int i, int j, Integer[][] memo) {
        if (memo[i][j] != null)
            return memo[i][j];

        if (i >= word1.length())
            return memo[i][j] = word2.length() - j;

        if (j >= word2.length())
            return memo[i][j] = word1.length() - i;

        if (word1.charAt(i) == word2.charAt(j))
            return memo[i][j] = minDistanceUtil(word1, word2, i + 1, j + 1, memo);

        int replace = 1 +  minDistanceUtil(word1, word2, i + 1, j + 1, memo);
        int delete = 1 +  minDistanceUtil(word1, word2, i + 1, j, memo);
        int insert = 1 + minDistanceUtil(word1, word2, i, j + 1, memo);
        return memo[i][j] = Math.min(insert, Math.min(replace, delete));
    }

    public static void main(String[] args) {
        EditDistance ed = new EditDistance();
        System.out.println(ed.minDistance("horse", "ros"));
        System.out.println(ed.minDistance("intention", "execution"));
    }
}
