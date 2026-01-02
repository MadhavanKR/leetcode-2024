package com.mk.leetcode.dynamic_programming;

/**
 * <a href="https://leetcode.com/problems/fibonacci-number">Fibonacci Number</a>
 */
public class FibonacciNumber {

    public int fib(int n) {
        int[] memo = new int[n+1];
        if (n == 0)
            return 0;
        else if (n <= 2)
            return 1;
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 1;
        for (int i = 3; i <= n; i++)
            memo[i] = memo[i-1] + memo[i-2];

        return memo[n];
    }

    public static void main(String[] args) {
        FibonacciNumber fibonacciNumber = new FibonacciNumber();
        System.out.println(fibonacciNumber.fib(5));
    }
}
