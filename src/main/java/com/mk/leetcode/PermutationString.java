package com.mk.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * https://leetcode.com/problems/permutation-in-string/
 */
public class PermutationString {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "adc";
        String s2 = "dcda";
        boolean answer = solution.checkInclusion(s1, s2);
        System.out.printf("answer = %b\n", answer);
    }

    static class Solution {
        public boolean checkInclusion(String s1, String s2) {
            if (s2.length() < s1.length())
                return false;

            Map<String, Integer> s1CountMap = new HashMap<>();
            Map<String, Integer> s2CountMap = new HashMap<>();


            for (int i = 0; i < s1.length(); i++) {
                String character = s1.substring(i, i + 1);
                s1CountMap.put(character, s1CountMap.getOrDefault(character, 0) + 1);

                character = s2.substring(i, i + 1);
                s2CountMap.put(character, s2CountMap.getOrDefault(character, 0) + 1);
            }

            int i = 0;
            int n = s2.length();
            int k = s1.length();
            while (i <= n - k) {
                boolean eq = true;
                for (String key : s1CountMap.keySet()) {
                    if (!Objects.equals(s2CountMap.getOrDefault(key, 0), s1CountMap.getOrDefault(key, 0))) {
                        eq = false;
                        break;
                    }
                }

                if (eq)
                    return eq;
                String key = s2.substring(i, i + 1);
                //    System.out.println("s2CountMap: " + s2CountMap);
                //    System.out.printf("i = %d key = %s\n", i, key);
                s2CountMap.put(key, s2CountMap.get(key) - 1);
                if (i + k < n) {
                    key = s2.substring(i + k, i + k + 1);

                    s2CountMap.put(key, s2CountMap.getOrDefault(key, 0) + 1);
                }
                i++;
            }
            return false;
        }
    }

}
