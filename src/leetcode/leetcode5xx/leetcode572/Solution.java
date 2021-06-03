package leetcode.leetcode5xx.leetcode572;

import leetcode.tools.TreeNode;

public class Solution {
    private static final long p = 31;
    private static final long d = Integer.MAX_VALUE;

    private static Result isSubtree(TreeNode root, long subRootHash) {
        if (root == null) return Result.empty;
        Result left = isSubtree(root.left, subRootHash);
        if (left.isSubtree) return Result.ok;
        Result right = isSubtree(root.right, subRootHash);
        if (right.isSubtree) return Result.ok;
        long hash = hashTree(root.val, left.hash, right.hash);
        if (hash == subRootHash) return Result.ok;
        return new Result(hash, false);
    }

    private static long hashTree(int val, long left, long right) {
        return (((left * p + d) * p + val) * p + d) * p + right;
    }

    private static long hashTree(TreeNode root) {
        if (root == null) return 0L;
        long ans = hashTree(root.left);
        ans = ans * p + d;
        ans = ans * p + root.val;
        ans = ans * p + d;
        ans = ans * p + hashTree(root.right);
        return ans;
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        long hash = hashTree(subRoot);
        return isSubtree(root, hash).isSubtree;
    }

    private static class Result {
        static final Result empty = new Result(0, false);
        static final Result ok = new Result(0, true);
        final long hash;
        final boolean isSubtree;

        Result(long hash, boolean isSubtree) {
            this.hash = hash;
            this.isSubtree = isSubtree;
        }
    }
}
