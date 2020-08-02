package leetcode.leetcode15xx.leetcode1530;

import leetcode.tools.TreeNode;

import java.util.LinkedList;

public class Solution {
    private static Result dfs(TreeNode node, int distance) {
        if (node.left == null && node.right == null) {
            LinkedList<Integer> count = new LinkedList<>();
            count.add(1);
            return new Result(0, count);
        } else if (node.left == null) {
            Result right = dfs(node.right, distance);
            right.count.addFirst(0);
            if (right.count.size() >= distance) right.count.removeLast();
            return right;
        } else if (node.right == null) {
            Result left = dfs(node.left, distance);
            left.count.addFirst(0);
            if (left.count.size() >= distance) left.count.removeLast();
            return left;
        } else {
            Result left = dfs(node.left, distance);
            Result right = dfs(node.right, distance);
            int res = left.res + right.res;
            for (int i = 0; i < left.count.size(); i++) {
                for (int j = Math.min(distance - i - 2, right.count.size() - 1); j >= 0; j--) {
                    res += left.count.get(i) * right.count.get(j);
                }
            }
            if (left.count.size() < right.count.size()) {
                Result tmp = left;
                left = right;
                right = tmp;
            }
            for (int i = right.count.size() - 1; i >= 0; i--) left.count.set(i, left.count.get(i) + right.count.get(i));
            left.count.addFirst(0);
            if (left.count.size() >= distance) left.count.removeLast();
            return new Result(res, left.count);
        }
    }

    public int countPairs(TreeNode root, int distance) {
        if (root == null || distance <= 1) return 0;
        return dfs(root, distance).res;
    }

    private static class Result {
        int res;
        LinkedList<Integer> count;

        public Result(int res, LinkedList<Integer> count) {
            this.res = res;
            this.count = count;
        }
    }
}
