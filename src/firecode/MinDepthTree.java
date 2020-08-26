package firecode;

import java.util.ArrayDeque;
import java.util.Queue;

public class MinDepthTree {
    public int minTreeDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int depth = 1;
        int currentGeneration = 1;
        while (true) {
            while (currentGeneration-- != 0) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) return depth;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            currentGeneration = queue.size();
            depth++;
        }
    }
}
