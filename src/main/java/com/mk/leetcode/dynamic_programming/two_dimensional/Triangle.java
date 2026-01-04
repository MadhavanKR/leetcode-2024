package com.mk.leetcode.dynamic_programming.two_dimensional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/triangle">Triangle</a>
 */
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> prevMemo = new ArrayList<>();
        prevMemo.add(triangle.get(0).get(0));
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> prevRow = triangle.get(i - 1);
            List<Integer> curRow = triangle.get(i);
            List<Integer> curMemo = new ArrayList<>();
            for (int j = 0; j < curRow.size(); j++) {
                if (j == 0)
                    curMemo.add(prevMemo.get(j) + curRow.get(j));
                else if (j == prevRow.size())
                    curMemo.add(prevMemo.get(j - 1) + curRow.get(j));
                else {
                    int minValue = Math.min(prevMemo.get(j - 1), prevMemo.get(j)) + curRow.get(j);
                    curMemo.add(j, minValue);
                }
            }
            prevMemo = curMemo;
        }
        return Collections.min(prevMemo);
    }

    private void printLists(List<List<Integer>> lists, String name) {
        System.out.println(name);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        System.out.println(triangle.minimumTotal(List.of(List.of(2), List.of(3, 4), List.of(6, 5, 7), List.of(4, 1, 8, 3))));
        System.out.println(triangle.minimumTotal(List.of(List.of(-10))));
    }
}
