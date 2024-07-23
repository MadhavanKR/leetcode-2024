package com.mk.leetcode;

public class JumpGame1 {

    public static void main(String[] args) {
        int[] input = {2,3,1,1,4};
        Solution solution = new Solution();
        boolean answer = solution.canJump(input);
        System.out.printf("answer = %b\n", answer);
    }

    static class Solution {
        public boolean canJump(int[] nums) {
            boolean[] canReachEnd = new boolean[nums.length];
            int n = nums.length;
            canReachEnd[n-1] = true;

            for (int i = n-2; i >=0; i--) {
                boolean curResult = false;
                for (int j = i+1; j < n && j <= i + nums[i]; j++) {
                    curResult = curResult || canReachEnd[j];
                    if (curResult)
                        break;
                }
                canReachEnd[i] = curResult;
            }
            return canReachEnd[0];
        }

        public boolean canJumpOptimized(int[] nums) {
            int n = nums.length;
            int targetIndex = n - 1; // defines the index from where we can reach the end index.

            for (int i=n-2; i>=0; i--) {
                if (i + nums[i] >= targetIndex) {
                    // means jumping from index i, with max jumps of nums[i], I can reach a point from where I can eventually
                    // reach the target. So I can update i as the new targetIndex
                    targetIndex = i;
                }
            }
            // if 0 is a targetIndex, then it means we can reach the end from 0th index, so we return true. If not, we return false
            return targetIndex == 0;
        }
    }
}
