package com.mk.leetcode.dynamic_programming.strings;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/word-break">Word Break</a>
 */
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] memo = new Boolean[s.length()];
        return wordBreakUtil(s, 0, new HashSet<>(wordDict), memo);
    }

    public boolean wordBreakUtil(String s, int start, Set<String> wordDict, Boolean[] memo) {
        if (start == s.length())
            return true;

        if (Objects.nonNull(memo[start]))
            return memo[start];

        boolean result = false;
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start,end)) && wordBreakUtil(s, end, wordDict, memo))
                return memo[start] = true;
        }
        return memo[start] = false;
    }

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        System.out.println(wordBreak.wordBreak("leetcode", List.of("leet","code")));
        System.out.println(wordBreak.wordBreak("catsandog", List.of("cats","dog","sand","and","cat")));
    }
}
