package com.mk.leetcode.dynamic_programming.binary_search_tree;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/house-robber-iii">House Robber III</a>
 */
public class HouseRobberIII {

    public int rob(TreeNode root) {
        Map<String, Integer> memo = new HashMap<>();
        return Math.max(robUtil(root, false, memo), robUtil(root, true, memo));
    }

    private int robUtil(TreeNode node, boolean skip, Map<String, Integer> memo) {
        if (node == null)
            return 0;

        String key = node.toString() + "~" + skip;
        if (memo.containsKey(key))
            return memo.get(key);

        int robAmtSkipped = robUtil(node.left, false, memo) + robUtil(node.right, false, memo);
        int robAmtConsider = node.val + robUtil(node.left, true, memo) + robUtil(node.right, true, memo);
        int res = skip ? robAmtSkipped : Math.max(robAmtSkipped, robAmtConsider);
        memo.put(key, res);
        return res;

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
