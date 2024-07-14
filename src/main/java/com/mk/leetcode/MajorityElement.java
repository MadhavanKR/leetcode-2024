package com.mk.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    /**
     * https://leetcode.com/problems/majority-element/description/?envType=study-plan-v2&envId=top-interview-150
     */
    public static void main(String[] args) {
        int[] input = {2,2,1,1,1,2,2};
        Solution solution = new Solution();
        int answer = solution.majorityElement(input);
        System.out.printf("answer = %d\n", answer);
    }

    static class Solution {
        public int majorityElement(int[] nums) {
            Map<Integer, Integer> countMap = new HashMap<>();
            int minReq = nums.length / 2;
            int result = 0;

            for (int num : nums) {
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
                if (countMap.get(num) > minReq) {
                    result = num;
                    break;
                }
            }
            return result;
        }
    }
}
