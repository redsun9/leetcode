package firecode;

import java.util.LinkedList;
import java.util.Queue;

public class SumBST {
    public int sumItr(TreeNode root) {
        if (root == null) return 0;
        int ans = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            ans += node.data;
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return ans;
    }
}
