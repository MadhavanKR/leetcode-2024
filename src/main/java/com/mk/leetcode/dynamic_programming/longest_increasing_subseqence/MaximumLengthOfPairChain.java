package com.mk.leetcode.dynamic_programming.longest_increasing_subseqence;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.com/problems/maximum-length-of-pair-chain/description">Maximum Length of Pair Chain</a>
 */
public class MaximumLengthOfPairChain {

    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        Integer[] memo = new Integer[n];
        Arrays.fill(memo, 1);

//        print2DArray(pairs, "before");
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return -1 * (ints[1] - t1[1]);
            }
        });

//        print2DArray(pairs, "after");

        int answer = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0 ; j < i; j++) {
                if (pairs[j][0] > pairs[i][1])
                    memo[i] = Math.max(memo[i], memo[j] + 1);
            }
            answer = Math.max(answer, memo[i]);
        }

        return answer;
    }


    private void print2DArray(int[][] arr, String message) {
        System.out.println(message);
        for (int i = 0; i < arr.length; i++)
            System.out.print(Arrays.toString(arr[i]) + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        MaximumLengthOfPairChain obj = new MaximumLengthOfPairChain();
        System.out.println(obj.findLongestChain(new int[][]{{1, 2}, {2, 3}, {3, 4}}));
        System.out.println(obj.findLongestChain(new int[][]{{1, 2}, {7, 8}, {4, 5}}));
        System.out.println(obj.findLongestChain(new int[][]{{1, 2}, {4, 5}, {7, 8}}));
    }
}
