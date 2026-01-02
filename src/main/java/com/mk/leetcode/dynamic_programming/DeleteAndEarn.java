package com.mk.leetcode.dynamic_programming;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/delete-and-earn">Delete And Earn</a>
 */
public class DeleteAndEarn {
    private HashMap<Integer, Integer> points = new HashMap<>();
    private HashMap<Integer, Integer> memo = new HashMap<>();

    public int deleteAndEarn(int[] nums) {
        int maxNumber = nums[0];
        for (int num : nums) {
            points.put(num, points.getOrDefault(num, 0) + num);
            maxNumber = Math.max(maxNumber, num);
        }
        return maxPoints(maxNumber);
    }

    /**
     * maxPoints(num) returns the maximum points that we can gain if we only consider all the elements in nums with values between 0 and num
     * maxPoints(0) will always be equal to 0. Second, when considering maxPoints(1),
     * we only care about the elements 0 and 1. We do not care about 2 because of how we defined maxPoints(x)
     * <p>
     * If we take x: We gain points[x] points, but cannot take x − 1, so the total becomes
     * gain[x] + maxPoints(x − 2).
     * <p>
     * If we skip x: We gain no points from x, but can still consider x − 1, so the total is
     * maxPoints(x − 1).
     */
    private int maxPoints(int number) {
        if (number == 0)
            return 0;

        if (number == 1)
            return points.getOrDefault(1, 0);

        if (memo.containsKey(number))
            return memo.get(number);

        int withDeletion = points.getOrDefault(number, 0) + maxPoints(number - 2);
        int withoutDeletion = maxPoints(number - 1);
        memo.put(number, Math.max(withDeletion, withoutDeletion));
        return memo.get(number);
    }

    public static void main(String[] args) {
        DeleteAndEarn demo = new DeleteAndEarn();
//        System.out.println(demo.deleteAndEarn(new int[]{3, 4, 2}));
        System.out.println(demo.deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));
    }
}
