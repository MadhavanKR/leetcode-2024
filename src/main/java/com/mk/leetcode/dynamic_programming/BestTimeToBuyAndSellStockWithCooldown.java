package com.mk.leetcode.dynamic_programming;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/">Best Time To Buy And Sell Stock With Cooldown</a>
 */
public class BestTimeToBuyAndSellStockWithCooldown {

    private static final int BUY = 0;
    private static final int SELL = 1;
    private static final int COOLDOWN = 2;

    public int maxProfit(int[] prices) {
        Integer[][] memo = new Integer[prices.length][3];
        return maxProfitUtil(prices, COOLDOWN, 0, memo);
//        return maxProfitIterative(prices);
    }

    /**
     * TODO: Incorrect implementation, need to tune it up.
     */
    private int maxProfitIterative(int[] prices) {
        Integer[][] memo = new Integer[prices.length][3];
        memo[0][BUY] = -prices[0];
        memo[0][COOLDOWN] = 0;
        memo[0][SELL] = Integer.MIN_VALUE;
        List<Integer> actions =  List.of(BUY, COOLDOWN, SELL);
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            for (int currentAction : actions) {
                switch (currentAction) {
                    case BUY:
                        memo[i][currentAction] = memo[i-1][COOLDOWN] - prices[i];
                    case SELL:
                        memo[i][currentAction] = memo[i-1][BUY] + prices[i];
                    case COOLDOWN:
                        memo[i][currentAction] = Math.max(memo[i-1][SELL], memo[i-1][BUY]);
                }
                ans = Math.max(ans, memo[i][currentAction]);
            }
        }
        return ans;
    }

    private int maxProfitUtil(int[] prices, int previousAction, int day, Integer[][] memo) {
        if (day >= prices.length)
            return 0;

        if (memo[day][previousAction] != null)
            return memo[day][previousAction];

        int maxProfit;
        if (previousAction == BUY) {
            int doNothingProfit = maxProfitUtil(prices, BUY, day + 1, memo);
            int sellProfit = prices[day] + maxProfitUtil(prices, SELL, day + 1, memo);
            maxProfit = Math.max(doNothingProfit, sellProfit);
        } else if (previousAction == SELL) {
            maxProfit = maxProfitUtil(prices, COOLDOWN, day + 1, memo);
        } else {
            int doNothingProfit = maxProfitUtil(prices, COOLDOWN, day + 1, memo);
            int buyProfit = maxProfitUtil(prices, BUY, day + 1, memo) - prices[day];
            maxProfit = Math.max(doNothingProfit, buyProfit);
        }
        return memo[day][previousAction] = maxProfit;

    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockWithCooldown sol = new BestTimeToBuyAndSellStockWithCooldown();
        System.out.println(sol.maxProfit(new int[]{1, 2, 3, 0, 2}));
        System.out.println(sol.maxProfit(new int[]{1}));
        System.out.println(sol.maxProfit(new int[]{1, 1, 2}));
    }

}
