package leetcode.leetcode6xx.leetcode623;

import leetcode.tools.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

@SuppressWarnings("ConstantConditions")
public class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        root = new TreeNode(0, root, null);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int level = 1;
        while (!queue.isEmpty()) {
            if (depth == level) {
                while (!queue.isEmpty()) {
                    TreeNode poll = queue.poll();
                    poll.left = new TreeNode(val, poll.left, null);
                    poll.right = new TreeNode(val, null, poll.right);
                }
                break;
            }
            int size = queue.size();
            while (size-- > 0) {
                TreeNode poll = queue.poll();
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
            }
            level++;
        }
        return root.left;
    }
}
