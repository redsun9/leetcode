package leetcode.leetcode1xx.leetcode111;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<CustomNode> queue = new ArrayDeque<>();
        queue.add(new CustomNode(root, 1));
        while (true) {
            CustomNode poll = queue.poll();
            if (poll.node.left != null || poll.node.right != null) {
                if (poll.node.left != null) queue.offer(new CustomNode(poll.node.left, poll.depth + 1));
                if (poll.node.right != null) queue.offer(new CustomNode(poll.node.right, poll.depth + 1));
            } else return poll.depth;
        }
    }

    private static class CustomNode {
        TreeNode node;
        int depth;

        public CustomNode(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}
