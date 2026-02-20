package com.mk.leetcode.dynamic_programming.one_dimensional;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/solving-questions-with-brainpower">Solving Questions With Brainpower</a>
 */
public class SolvingQuestionsWithBrainPower {

    public long mostPoints(int[][] questions) {
        Long[] memo = new Long[questions.length];
//        long answer = mostPointsUtil(questions, 0, memo);
        long answer = mostPointsIterative(questions);
        return answer;
    }

    private long mostPointsUtil(int[][] questions, int index, Long[] memo) {
        if (index >= questions.length)
            return 0;

        if (memo[index] != null)
            return memo[index];

        int points = questions[index][0];
        int brainPower = questions[index][1];
        long solvingQuestion = points + mostPointsUtil(questions, index + brainPower + 1, memo);
        long notSolvingQuestion = mostPointsUtil(questions, index + 1, memo);
//        if (solvingQuestion >  notSolvingQuestion)
//            System.out.printf("For index %s solving question is better\n", index);
//        else
//            System.out.printf("For index %s NOT solving question is better\n", index);
        return memo[index] = Math.max(solvingQuestion, notSolvingQuestion);
    }

    private long mostPointsIterative(int[][] questions) {
        int n = questions.length;
        long[] memo = new long[n];
        memo[n - 1] = questions[n - 1][0];

        for (int i = n - 2; i >= 0; i--) {
            int points = questions[i][0];
            int brainPower = questions[i][1];
            // not solving the question
            long notSolvingQuestion = memo[i + 1];

            // solving the question
            long solvingQuestion = points;
            if (i + brainPower + 1 < n)
                solvingQuestion += memo[i + brainPower + 1];
            memo[i] = Math.max(solvingQuestion, notSolvingQuestion);
        }
        return memo[0];
    }

    public static void main(String[] args) {
        SolvingQuestionsWithBrainPower sol = new SolvingQuestionsWithBrainPower();
        System.out.println(sol.mostPoints(new int[][]{{3, 2}, {4, 3}, {4, 4}, {2, 5}}));
        System.out.println(sol.mostPoints(new int[][]{{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}}));
    }
}
