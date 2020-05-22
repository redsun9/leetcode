package leetcode.leetcode8xx.leetcode897;

import leetcode.tools.TreeNode;

public class Solution {
    public TreeNode increasingBST(TreeNode root) {
        return dfs(root).root;
    }

    private static Pair dfs(TreeNode root) {
        if (root.left != null) {
            Pair left = dfs(root.left);
            left.child.right = root;
            root.left = null;
            if (root.right != null) {
                Pair right = dfs(root.right);
                root.right = right.root;
                return new Pair(left.root, right.child);
            } else {
                return new Pair(left.root, root);
            }
        } else if (root.right != null) {
            Pair right = dfs(root.right);
            root.right = right.root;
            return new Pair(root, right.child);
        } else return new Pair(root, root);
    }

    private static class Pair {
        private final TreeNode root, child;

        public Pair(TreeNode root, TreeNode child) {
            this.root = root;
            this.child = child;
        }
    }
}
