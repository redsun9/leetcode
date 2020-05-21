package leetcode.leetcode9xx.leetcode979;

import leetcode.tools.TreeNode;

public class Solution {
    public int distributeCoins(TreeNode root) {
        return dfs(root).sum;
    }

    private static Pair dfs(TreeNode root) {
        int balance = root.val - 1;
        if (root.left == null && root.right == null) return new Pair(balance, Math.abs(balance));
        int sum = 0;
        if (root.left != null) {
            Pair pair = dfs(root.left);
            balance += pair.balance;
            sum += pair.sum;
        }
        if (root.right != null) {
            Pair pair = dfs(root.right);
            balance += pair.balance;
            sum += pair.sum;
        }
        return new Pair(balance, sum + Math.abs(balance));
    }

    private static class Pair {
        int balance, sum;

        public Pair(int balance, int sum) {
            this.balance = balance;
            this.sum = sum;
        }
    }
}
