package com.mk.leetcode.dynamic_programming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/coin-change-ii">Coin Change II</a>
 */
public class CoinChangeII {

    public int change(int amount, int[] coins) {
//        Map<Integer, Integer> memo = new HashMap<>();
//        int answer = changeUtil(amount, coins, memo);
//        System.out.println(memo);
//        return answer;
        return changeIterative(amount, coins);
    }

    private int changeIterative(int amount, int[] coins) {

        if (amount == 0)
            return 1;

        int numCoins = coins.length;
        int[][] memo = new int[numCoins][amount + 1];
        for (int i = 0; i < numCoins; i++) {
            memo[i][0] = 0;
        }

        for (int j = 1; j <= amount; j++)
            memo[0][j] = j % coins[0] == 0 ? 1 : 0;

//        printMatrix(memo, "After Init Memo");

        for (int coinNum = 1; coinNum < numCoins; coinNum++) {
            for (int curAmount = 1; curAmount <= amount; curAmount++) {
                int numWaysExcludingCurrentCoin = memo[coinNum - 1][curAmount];
                int numWaysIncludingCurrentCoin = 0;
                int remAmount = curAmount - coins[coinNum];
                if (remAmount > 0)
                    numWaysIncludingCurrentCoin = memo[coinNum][remAmount];
                else if (remAmount == 0)
                    numWaysIncludingCurrentCoin = 1;

                memo[coinNum][curAmount] = numWaysIncludingCurrentCoin +  numWaysExcludingCurrentCoin;
            }
        }

//        printMatrix(memo, "After Computing Memo");
        return memo[numCoins - 1][amount];
    }

    public void printMatrix(int[][] matrix, String matrixName) {
        System.out.println(matrixName);
        for (int[] ints : matrix) System.out.println(Arrays.toString(ints));
    }

    private int changeUtil(int amount, int[] coins, Map<Integer, Integer> memo) {
        if (amount < 0)
            return 0;

        if (amount == 0)
            return 1;

        if (memo.containsKey(amount))
            return memo.get(amount);

        int res = 0;
        for (int coin : coins) {
            res += changeUtil(amount - coin, coins, memo);
        }
        memo.put(amount, res);
        return res;
    }

    public static void main(String[] args) {
        CoinChangeII cc = new CoinChangeII();
        System.out.println(cc.change(5, new int[]{1, 2, 5}));
        System.out.println(cc.change(3, new int[]{2}));
        System.out.println(cc.change(10, new int[]{10}));
        System.out.println(cc.change(5, new int[]{2, 5}));
    }

}
