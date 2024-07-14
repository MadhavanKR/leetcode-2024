/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mk.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author keerthanamadhavan
 * link: https://leetcode.com/problems/maximum-units-on-a-truck/description/
 */
public class MaximumUnitsInTruck {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] boxTypes = {{1,3}, {2,2}, {3,1}};
        int truckSize = 4;
        int answer = solution.maximumUnits(boxTypes, truckSize);
        System.out.println("answer: " + answer);
    }

    public static class Solution {

        public int maximumUnits(int[][] boxTypes, int truckSize) {
            int result = 0;
            Arrays.sort(boxTypes, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[1] - o1[1];
                }
            });
            System.out.println("After sorting by number of units: ");
//            for (int[] boxType : boxTypes) {
//                System.out.println(String.format("{%s, %s}", boxType[0], boxType[1]));
//            }
//
            for (int[] boxType : boxTypes) {
                int pickBoxCount = Math.min(boxType[0], truckSize);
                result += (pickBoxCount * boxType[1]);
                truckSize -= pickBoxCount;
            }
            return result;
        }

    }
}
