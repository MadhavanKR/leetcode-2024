package com.mk.leetcode.dynamic_programming;

/**
 * <a href="https://leetcode.com/problems/domino-and-tromino-tiling">Domino And Tromino Tiling</a>
 */
public class DominoAndTrominoTiling {

    public int numTilings(int n) {
        long MOD = 1_000_000_007;
        long[] fullTilingsMemo =  new long[n+1];
        long[] partialTilingsMemo =  new long[n+1];

        if (n == 1)
            return 1;

        fullTilingsMemo[1] = 1;
        fullTilingsMemo[2] = 2;

        partialTilingsMemo[2] = 1;

        for (int i = 3; i <= n; i++) {
            fullTilingsMemo[i] = (fullTilingsMemo[i-1]  + fullTilingsMemo[i-2] + (2 * partialTilingsMemo[i-1])) % MOD;
            partialTilingsMemo[i] = (partialTilingsMemo[i-1] + fullTilingsMemo[i-2]) % MOD;
        }

        return (int)fullTilingsMemo[n];
    }

    public static void main(String[] args) {
        DominoAndTrominoTiling sol = new DominoAndTrominoTiling();
        System.out.println(sol.numTilings(3));
        System.out.println(sol.numTilings(4));
        System.out.println(sol.numTilings(5));
    }
}
