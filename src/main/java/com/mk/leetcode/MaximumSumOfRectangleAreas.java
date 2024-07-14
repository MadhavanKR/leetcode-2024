package com.mk.leetcode;

import java.util.*;

public class MaximumSumOfRectangleAreas {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] inputs = {{2, 6, 6, 2, 3, 5}, {2, 1, 6, 5, 4, 4}, {2, 3, 3, 4, 6, 6, 8, 8}, {2, 4, 6, 1, 3, 5}};
        int[] expectedOutputs = {12, 20 , 54, 12};

        for (int i=0; i<inputs.length; i++) {
            int answer = solution.maximumSumOfRectangleAreas(inputs[i]);
            System.out.printf("input: %s\n", Arrays.toString(inputs[i]));
            System.out.printf("expected answer: %d, actual answer: %d\n", expectedOutputs[i], answer);
            System.out.println("==================");
        }
    }

    public static class Solution {

        public int maximumSumOfRectangleAreas(int[] stickLengths) {
            long mod = 10000000L;

            Map<Integer, Integer> freqMap = new TreeMap<>(Collections.reverseOrder());
            for(int stickLength: stickLengths)
                freqMap.put(stickLength, freqMap.getOrDefault(stickLength, 0) + 1);

            System.out.printf("Before: frequency map: %s\n", freqMap);

            List<Integer> rectangleSides = new ArrayList<>();

            for (Map.Entry<Integer, Integer> stickFreq : freqMap.entrySet()) {
                int stickLength = stickFreq.getKey();
                int stickCount = stickFreq.getValue();
                System.out.printf("Before: Processing stickLength: %d with %d count\n", stickLength, stickCount);

                if (freqMap.getOrDefault(stickLength +  1, 0) > 0) {
                    stickCount = stickCount + freqMap.getOrDefault(stickLength +  1, 0);
                }

                System.out.printf("After: Processing stickLength: %d with %d count\n", stickLength, stickCount);

                while (stickCount >= 2) {
                    rectangleSides.add(stickLength);
                    stickCount = stickCount - 2;
                }

//                if (stickCount == 1 && freqMap.getOrDefault(stickLength + 1, 0) > 0) {
//                    stickCount = 0;
//                    rectangleSides.add(stickLength);
//                    freqMap.put(stickLength + 1, freqMap.getOrDefault(stickLength + 1, 0) - 1);
//                }



                freqMap.put(stickLength, stickCount);
            }

            System.out.printf("After: frequency map: %s\n", freqMap);
            rectangleSides.sort(Comparator.reverseOrder());

            System.out.printf("rectangle sides are: %s\n", rectangleSides);

            int answer = 0;

            for (int i=0; i < rectangleSides.size() - 1; i=i+2) {
                int area = rectangleSides.get(i) * rectangleSides.get(i+1);
                answer = (int) ((answer + area) % mod);
            }

            return answer;
        }
    }
}
