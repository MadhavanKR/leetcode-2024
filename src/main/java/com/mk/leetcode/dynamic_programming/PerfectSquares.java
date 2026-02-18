package com.mk.leetcode.dynamic_programming;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class PerfectSquares {

    public int numSquares(int n) {
        Set<Integer> perfectSquares = new LinkedHashSet<>();
        for (int i = 1; i*i <= n; i++)
            perfectSquares.add(i*i);

//        System.out.println("Perfect squares: " + perfectSquares);
        Map<Integer, Integer> memo = new HashMap<>();

        int answer = numSquaresUtil(n, perfectSquares, memo);
//        System.out.println(memo);
        return answer;
    }

    private int numSquaresUtil(int n, Set<Integer> perfectSquares, Map<Integer, Integer> memo) {
        if (n < 0)
            return Integer.MAX_VALUE / 2;

        if (n == 0)
            return 0;

        if (memo.containsKey(n))
            return memo.get(n);

        if (perfectSquares.contains(n)) {
            memo.put(n, 1);
            return 1;
        }

        int res = Integer.MAX_VALUE / 2;
        for (int ps : perfectSquares) {
            int curRes = numSquaresUtil(n - ps,  perfectSquares, memo) + 1;
//            System.out.printf("For n = %d, including %d will have remaining sum = %d and result = %d\n",  n, ps, n - ps, curRes);
            res = Math.min(res, curRes);
        }
//        System.out.printf("setting memory for n = %d with %d\n", n, res);
        memo.put(n, res);
        return res;
    }

    public static void main(String[] args) {
        PerfectSquares sol = new PerfectSquares();
        System.out.println(sol.numSquares(12));
        System.out.println(sol.numSquares(13));
    }
}
