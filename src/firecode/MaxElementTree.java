package firecode;

import java.util.LinkedList;
import java.util.Queue;

public class MaxElementTree {
    public int findMaxItr(TreeNode root) {
        int ans = Integer.MIN_VALUE;
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            ans = Math.max(ans, node.data);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return ans;
    }
}
