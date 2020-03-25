package leetcode.leetcode226;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        TreeNode tmp = null;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            tmp = poll.right;
            poll.right = poll.left;
            poll.left = tmp;
            if (poll.right != null) queue.add(poll.right);
            if (poll.left != null) queue.add(poll.left);
        }
        return root;
    }
}
