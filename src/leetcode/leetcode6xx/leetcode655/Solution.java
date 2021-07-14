package leetcode.leetcode6xx.leetcode655;

import leetcode.tools.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {
    private static int depth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(depth(root.left), depth(root.right));
    }

    public List<List<String>> printTree(TreeNode root) {
        int h = depth(root);
        int w = (1 << h) - 1;

        List<List<String>> ans = new ArrayList<>(h);
        for (int i = 0; i < h; i++) {
            List<String> row = new ArrayList<>(w);
            for (int j = 0; j < w; j++) row.add("");
            ans.add(row);
        }

        Queue<QueueNode> queue = new ArrayDeque<>();
        queue.add(new QueueNode(root, 0, w / 2, w / 2 + 1));
        while (!queue.isEmpty()) {
            QueueNode poll = queue.poll();
            TreeNode node = poll.node;
            ans.get(poll.i).set(poll.j, Integer.toString(node.val));
            if (node.left != null)
                queue.add(new QueueNode(node.left, poll.i + 1, poll.j - poll.d / 2, poll.d / 2));
            if (node.right != null)
                queue.add(new QueueNode(node.right, poll.i + 1, poll.j + poll.d / 2, poll.d / 2));
        }
        return ans;
    }

    private static class QueueNode {
        final TreeNode node;
        final int i, j, d;

        public QueueNode(TreeNode node, int i, int j, int d) {
            this.node = node;
            this.i = i;
            this.j = j;
            this.d = d;
        }
    }
}
