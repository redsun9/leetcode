package leetcode.leetcode9xx.leetcode919;

import leetcode.tools.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

@SuppressWarnings("ConstantConditions")
public class CBTInserter {
    private final Queue<TreeNode> q = new ArrayDeque<>();
    private TreeNode root;

    public CBTInserter(TreeNode root) {
        this.root = root;
        q.add(root);
        while (q.peek().right != null) {
            TreeNode poll = q.poll();
            q.add(poll.left);
            q.add(poll.right);
        }
    }

    public int insert(int v) {
        TreeNode node = q.peek();
        if (node.left == null) node.left = new TreeNode(v);
        else {
            node.right = new TreeNode(v);
            q.poll();
            q.add(node.left);
            q.add(node.right);
        }
        return node.val;
    }

    public TreeNode get_root() {
        return root;
    }
}
