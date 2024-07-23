package com.mk.leetcode;

public class TrapWater {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] input = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] input = {0,2,0,3,1,0,1,3,2,1};
        int answer = solution.trap(input);
        System.out.printf("answer = %d\n", answer);
    }

    static class Solution {
        public int trap(int[] height) {
            if (height.length <= 1)
                return 0;

            int i = 0;
            int j = i + 1;
            int answer = 0;
            while (j < height.length) {
               if (height[j] >= height[i]) {
                   for (int k=i+1; k<j; k++)
                       answer += (height[i] - height[k]);
                   i = j;
               }
               j++;
            }
//            System.out.printf("with i=%d and j=%d, answer = %d\n", i, j, answer);
            for (int k = i+1; k<height.length-1; k++) {
                if (height[k] < height[k-1] && height[k] < height[k+1]) {
                    answer += (Math.min(height[k - 1], height[k + 1]) - height[k]);
//                    System.out.printf("updating answer with %d\n", Math.min(height[k - 1], height[k + 1]) - height[k]);
                }
            }

            return answer;
        }
    }

}
