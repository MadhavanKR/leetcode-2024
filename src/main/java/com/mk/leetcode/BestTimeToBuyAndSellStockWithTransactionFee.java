package com.mk.leetcode;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee">Best Time to Buy and Sell Stock with Transaction Fee</a>
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {

    private static final int BUY = 0;
    private static final int SELL = 1;
    private static final int COOLDOWN = 2;

    public int maxProfit(int[] prices, int fee) {
        Integer[][] memo = new Integer[prices.length][3];
        return maxProfitUtil(prices, COOLDOWN, 0, memo, fee);
    }


    private int maxProfitUtil(int[] prices, int previousAction, int day, Integer[][] memo, int fee) {
        if (day >= prices.length)
            return 0;

        if (memo[day][previousAction] != null)
            return memo[day][previousAction];

        // only difference between BuyAndSellStockWithCoolDown is that we've to apply transaction fees when we sell.
        // There is no cooldown period, so we buy immediately after selling.
        int maxProfit;
        if (previousAction == BUY) {
            int doNothingProfit = maxProfitUtil(prices, BUY, day + 1, memo, fee);
            int sellProfit = maxProfitUtil(prices, SELL, day + 1, memo, fee) + prices[day] - fee;
            maxProfit = Math.max(doNothingProfit, sellProfit);
        } else {
            int doNothingProfit = maxProfitUtil(prices, COOLDOWN, day + 1, memo, fee);
            int buyProfit = maxProfitUtil(prices, BUY, day + 1, memo, fee) - prices[day];
            maxProfit = Math.max(doNothingProfit, buyProfit);
        }
        return memo[day][previousAction] = maxProfit;

    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockWithTransactionFee sol = new BestTimeToBuyAndSellStockWithTransactionFee();
        System.out.println(sol.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
        System.out.println(sol.maxProfit(new int[]{1, 3, 7, 5, 10, 3}, 3));
    }

}
