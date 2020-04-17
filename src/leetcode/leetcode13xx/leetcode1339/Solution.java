package leetcode.leetcode13xx.leetcode1339;

import leetcode.tools.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    private static final int m = 1_000_000_007;

    public int maxProduct(TreeNode root) {
        long sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            sum += poll.val;
            if (poll.left != null) queue.add(poll.left);
            if (poll.right != null) queue.add(poll.right);
        }
        long max = 0;
        Stack<StackNode> stack = new Stack<>();
        stack.push(new StackNode(root));
        while (!stack.isEmpty()) {
            StackNode peek = stack.peek();
            if (peek.processed) {
                long subSum = peek.node.val;
                if (peek.left != null) subSum += peek.left.subSum;
                if (peek.right != null) subSum += peek.right.subSum;
                max = Math.max(max, subSum * (sum - subSum));
                peek.subSum = subSum;
                stack.pop();
            } else {
                peek.processed = true;
                if (peek.node.left != null) {
                    StackNode left = new StackNode(peek.node.left);
                    peek.left = left;
                    stack.push(left);
                }
                if (peek.node.right != null) {
                    StackNode right = new StackNode(peek.node.right);
                    peek.right = right;
                    stack.push(right);
                }
            }
        }
        return (int) (max % m);
    }

    private static class StackNode {
        TreeNode node;
        long subSum;
        boolean processed;
        StackNode left, right;

        public StackNode(TreeNode node) {
            this.node = node;
        }
    }
}
