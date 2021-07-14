package leetcode.leetcode6xx.leetcode652;

import leetcode.tools.TreeNode;

import java.util.*;

public class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        int counter = 1;
        Map<String, Integer> idMap = new HashMap<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        List<TreeNode> ans = new ArrayList<>();
        ArrayDeque<Result> stack = new ArrayDeque<>();
        stack.addLast(new Result(root));
        while (!stack.isEmpty()) {
            Result peek = stack.peekLast();
            if (peek.processed) {
                stack.pollLast();
                int left = peek.leftResult == null ? 0 : peek.leftResult.id;
                int right = peek.rightResult == null ? 0 : peek.rightResult.id;
                String hash = left + "," + peek.tree.val + "," + right;
                Integer id = idMap.getOrDefault(hash, counter);
                peek.id = id;
                if (id == counter) counter++;
                idMap.put(hash, id);
                if (countMap.compute(id, (k, v) -> v == null ? 1 : v + 1) == 2) ans.add(peek.tree);
            } else {
                peek.processed = true;
                if (peek.tree.left != null) {
                    peek.leftResult = new Result(peek.tree.left);
                    stack.addLast(peek.leftResult);
                }
                if (peek.tree.right != null) {
                    peek.rightResult = new Result(peek.tree.right);
                    stack.addLast(peek.rightResult);
                }
            }
        }
        return ans;
    }

    private static class Result {
        final TreeNode tree;
        Result leftResult, rightResult;
        int id;
        boolean processed;

        public Result(TreeNode tree) {
            this.tree = tree;
        }
    }
}
