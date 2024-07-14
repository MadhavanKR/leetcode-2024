package com.mk.leetcode;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class BestTimeToBuyAndSellStock1 {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        Solution solution = new Solution();
        int answer = solution.maxProfit(prices);
        System.out.printf("answer = %d\n", answer);
    }

    static class Solution {
        public int maxProfit(int[] prices) {
            int[] maxArr = new int[prices.length];
            int n = maxArr.length;
            maxArr[n - 1] = prices[n - 1];

            int result = 0;
            for (int i = n-2; i>=0; i--) {
                maxArr[i] = Math.max(maxArr[i+1], prices[i]);
                result = Math.max(result, maxArr[i] - prices[i]);
            }

            return result;
        }

        public int maxProfitOptimized(int[] prices) {
            int result = 0;
            int buyDay = 0;

            for (int i=0; i<prices.length; i++) {
                if (prices[i] < prices[buyDay])
                    buyDay = i;
                result = Math.max(result, prices[i] - prices[buyDay]);
            }

            return result;
        }
    }

}
