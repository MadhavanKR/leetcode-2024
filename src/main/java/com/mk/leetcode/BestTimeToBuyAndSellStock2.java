package com.mk.leetcode;

public class BestTimeToBuyAndSellStock2 {

    public static void main(String[] args) {
        int[] input = {7,1,5,3,6,4};
        Solution solution = new Solution();
        int answer = solution.maxProfit(input);
        System.out.printf("answer = %d\n", answer);
    }

    static class Solution {
        public int maxProfit(int[] prices) {

            int result = 0;
            int buyPoint = prices[0];
            int i = 1;
            while (i < prices.length) {
                while (i < prices.length && prices[i] > prices[i - 1]) {
                    i++;
                }

                if (i == prices.length) {
                    result = Math.max(result, result + prices[i-1] - buyPoint);
                } else {
                    result = Math.max(result, result + prices[i - 1] - buyPoint);
                    buyPoint = prices[i++];
                }
            }
            return result;
        }
    }
}
