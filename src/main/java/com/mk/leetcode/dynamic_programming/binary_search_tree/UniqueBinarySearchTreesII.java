package com.mk.leetcode.dynamic_programming.binary_search_tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/unique-binary-search-trees-ii">Unique Binary Search Trees II</a>
 */
public class UniqueBinarySearchTreesII {


    public List<TreeNode> generateTrees(int n) {

        // holds list of BSTs that can be formed for a given range (m, n)
        Map<String,List<TreeNode>> memo = new HashMap<>();

        return generateTreesUtil(1, n, memo);
    }

    private List<TreeNode> generateTreesUtil(int start, int end, Map<String, List<TreeNode>> memo) {
        if (start == end)
            return List.of(new TreeNode(start));

        if (start > end) {
            List<TreeNode> res = new ArrayList<>();
            res.add(null);
            return res;
        }

        String key = start + "~" + end;
        if (memo.containsKey(key))
            return memo.get(key);

        List<TreeNode> allSubTrees = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftSubTrees = generateTreesUtil(start, i - 1, memo);
            List<TreeNode> rightSubTrees = generateTreesUtil(i + 1, end, memo);
            for (TreeNode leftSubTree : leftSubTrees) {
                for (TreeNode rightSubTree : rightSubTrees) {
                    allSubTrees.add(new TreeNode(i, leftSubTree, rightSubTree));
                }
            }
        }
        memo.put(key, allSubTrees);
        return allSubTrees;
    }

    public static void main(String[] args) {
        UniqueBinarySearchTreesII sol = new UniqueBinarySearchTreesII();
        System.out.println(sol.generateTrees(4));
        System.out.println(sol.generateTrees(3));
        System.out.println(sol.generateTrees(1));
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
