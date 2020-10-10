package leetcode.tools;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        Queue<TreeNode> queue1 = new ArrayDeque<>();
        Queue<TreeNode> queue2 = new ArrayDeque<>();
        queue1.add(this);
        queue2.add(treeNode);
        while (!queue1.isEmpty()) {
            TreeNode a = queue1.poll();
            TreeNode b = queue2.poll();
            if (a == b) continue;
            if (
                    a.val != b.val
                            || (a.left == null ^ b.left == null)
                            || (a.right == null ^ b.right == null)
            ) return false;
            if (a.left != null) {
                queue1.add(a.left);
                queue2.add(b.left);
            }
            if (a.right != null) {
                queue1.add(a.right);
                queue2.add(b.right);
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }
}
