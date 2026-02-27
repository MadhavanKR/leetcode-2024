package com.mk.leetcode.dynamic_programming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/minimum-cost-for-tickets">Minimum Cost For Tickets</a>
 */
public class MinimumCostOfTickets {

    public int mincostTickets(int[] days, int[] costs) {
        if (costs.length == 0)
            return -1;

        Set<Integer> daysSet = new HashSet<>();
        for (int day : days)
            daysSet.add(day);

        int[] memo = new int[366];
        int n = days.length;

        System.out.println("Memo after initialization" + Arrays.toString(memo));
        memo[days[n-1]] = Arrays.stream(costs).min().getAsInt();
        for (int i = n - 2; i >= 0; i--) {
            int dailyPassCost = costs[0];
            int nearestDay = findNearestDay(days, i, 1);
            if (nearestDay != -1)
                dailyPassCost += memo[nearestDay];

            int weeklyPassCost = costs[1];
            nearestDay = findNearestDay(days, i, 7);
            if (nearestDay != -1)
                weeklyPassCost += memo[nearestDay];

            int monthlyPassCost = costs[2];
            nearestDay = findNearestDay(days, i, 30);
            if (nearestDay != -1)
                monthlyPassCost += memo[nearestDay];

            memo[days[i]] = Math.min(dailyPassCost, Math.min(weeklyPassCost, monthlyPassCost));
        }
        return memo[days[0]];
    }

    private int findNearestDay(int[] days, int startDayIndex,  int numDaysDiff) {
        for (int i = startDayIndex + 1; i < days.length; i++) {
            if (days[i] >= days[startDayIndex] + numDaysDiff)
                return days[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        MinimumCostOfTickets solution = new MinimumCostOfTickets();
        System.out.println(solution.mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15}));
        System.out.println(solution.mincostTickets(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31}, new int[]{2, 7, 15}));
    }
}
