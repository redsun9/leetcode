package leetcode.leetcode5xx.leetcode572;

import leetcode.tools.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Cache cache = new Cache();
        int subRootHash = hash(subRoot, cache);
        return isSubtree(root, subRootHash, cache).ans;
    }

    private static Result isSubtree(TreeNode root, int subRootHash, Cache cache) {
        if (root == null) return new Result(false, 0);
        Result left = isSubtree(root.left, subRootHash, cache);
        if (left.ans) return new Result(true, 0);
        Result right = isSubtree(root.right, subRootHash, cache);
        if (right.ans) return new Result(true, 0);
        int hash = cache.get(new Hash(left.hash, root.val, right.hash));
        return new Result(hash == subRootHash, hash);
    }

    private record Result(boolean ans, int hash) {
    }

    private record Hash(int left, int val, int right) {
    }

    private static int hash(TreeNode root, Cache cache) {
        if (root == null) return 0;
        int left = hash(root.left, cache);
        int right = hash(root.right, cache);
        Hash hash = new Hash(left, root.val, right);
        return cache.get(hash);
    }

    private static class Cache {
        int counter = 0;
        final Map<Hash, Integer> map = new HashMap<>();

        int get(Hash hash) {
            Integer val = map.get(hash);
            if (val != null) return val;
            map.put(hash, ++counter);
            return counter;
        }
    }
}
