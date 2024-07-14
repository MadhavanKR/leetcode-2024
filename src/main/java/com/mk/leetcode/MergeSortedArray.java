package com.mk.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MergeSortedArray {


    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2, 5, 6};
        int m = 3;
        int n = 3;

        solution.merge(nums1, m, nums2, n);

        System.out.printf("answer: %s\n", Arrays.toString(nums1));
    }

    static class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int i = m - 1;
            int j = n - 1;

            int endIndex = m + n - 1;

            // start populating from the end, we know large elements must be in the end
            while (i >= 0 && j >= 0) {

                if (nums1[i] > nums2[j]) {
                    nums1[endIndex--] = nums1[i--];
                } else {
                    nums1[endIndex--] = nums2[j--];
                }

            }

            while (j >= 0)
                nums1[endIndex--] = nums2[j--];

            while (i >= 0)
                nums1[endIndex--] = nums1[i--];
        }
    }
}
