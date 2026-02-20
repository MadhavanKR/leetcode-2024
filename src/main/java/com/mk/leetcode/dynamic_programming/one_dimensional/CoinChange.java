package com.mk.leetcode.dynamic_programming.one_dimensional;

/**
 * <a href="https://leetcode.com/problems/coin-change">Coin Change</a>
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;

        Integer[] memo = new Integer[amount + 1];
        int ans = coinChangeUtil(coins, amount, memo);
//        System.out.println(Arrays.toString(memo));
        if (ans >= (Integer.MAX_VALUE / 2) )
            ans = -1;
        return ans;
    }

    private int coinChangeUtil(int[] coins, int amount, Integer[] memo) {
        if (amount == 0)
            return 0;

        if (memo[amount] != null)
            return memo[amount];

        int res = Integer.MAX_VALUE / 2;
        for (int coin : coins) {
            if (amount - coin >= 0)
                res = Math.min(res, 1 + coinChangeUtil(coins, amount - coin, memo));
        }
        return memo[amount] = res;
    }

    public static void main(String[] args) {
        CoinChange c = new CoinChange();
        System.out.println(c.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(c.coinChange(new int[]{2}, 3));
        System.out.println(c.coinChange(new int[]{1}, 0));
    }
}
