package leetcode.leetcode4xx.leetcode404;

import leetcode.tools.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution3 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int ans = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null && node.left.left == null && node.left.right == null) ans += node.left.val;
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return ans;
    }
}
