package com.mk.leetcode.dynamic_programming;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/decode-ways">Decode ways</a>
 */
public class DecodeWays {

    private static Set<String> validMappings = new HashSet<>();
    static {
        for (int i = 1; i <= 26; i++)
            validMappings.add(String.valueOf(i));
    }
    public int numDecodings(String s) {
        Set<String> validMappings = new HashSet<>();
        for (int i = 1; i <= 26; i++)
            validMappings.add(String.valueOf(i));
        int n = s.length();
        int[] memo =  new int[n + 1];
        memo[n] = 1;
        memo[n-1] = validMappings.contains(String.valueOf(s.charAt(n-1))) ? 1 : 0;
        for (int i = n-2; i >= 0; i--) {
            String singleChar =  s.substring(i, i + 1);
            if (validMappings.contains(singleChar))
                memo[i] += memo[i+1];
            String doubleChars = s.substring(i, i + 2);
            if (validMappings.contains(doubleChars))
                memo[i] += memo[i+2];
        }
        return memo[0];
    }

    public static void main(String[] args) {
        DecodeWays sol = new DecodeWays();
        System.out.println(sol.numDecodings("12"));
        System.out.println(sol.numDecodings("226"));
        System.out.println(sol.numDecodings("06"));
    }
}
