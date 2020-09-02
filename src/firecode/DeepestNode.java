package firecode;

import java.util.LinkedList;
import java.util.Queue;

public class DeepestNode {
    public TreeNode findDeepest(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode ans = null;
        while (!queue.isEmpty()) {
            ans = queue.poll();
            if (ans.left != null) queue.add(ans.left);
            if (ans.right != null) queue.add(ans.right);
        }
        return ans;
    }
}
