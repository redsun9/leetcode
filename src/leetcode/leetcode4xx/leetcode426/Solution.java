package leetcode.leetcode4xx.leetcode426;

import leetcode.tools.TreeNode;

public class Solution {
    /**
     * @param root: root of a tree
     * @return head node of a doubly linked list
     */
    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) {
            root.left = root;
            root.right = root;
            return root;
        }
        if (root.right != null && root.left != null) {
            TreeNode left = treeToDoublyList(root.left);
            TreeNode right = treeToDoublyList(root.right);
            root.right = right;
            root.left = left.left;

            left.left.right = root;
            right.left.right = left;
            left.left = right.left;
            right.left = root;
            return left;
        }
        if (root.left != null) {
            TreeNode left = treeToDoublyList(root.left);
            left.left.right = root;
            root.left = left.left;
            left.left = root;
            root.right = left;
            return left;
        } else {
            TreeNode right = treeToDoublyList(root.right);
            right.left.right = root;
            root.left = right.left;
            right.left = root;
            root.right = right;
            return root;
        }
    }
}
