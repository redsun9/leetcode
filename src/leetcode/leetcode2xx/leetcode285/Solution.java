package leetcode.leetcode2xx.leetcode285;

import leetcode.tools.TreeNode;

import java.util.Stack;

public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        BstIncreasingIterator iterator = new BstIncreasingIterator(root, p.val);
        iterator.pop();
        return iterator.isEmpty() ? null : iterator.peek();
    }

    static class BstIncreasingIterator {
        private final Stack<TreeNode> stack = new Stack<>();

        BstIncreasingIterator(TreeNode root, double target) {
            while (root != null) {
                if (root.val >= target) {
                    stack.push(root);
                    root = root.left;
                } else root = root.right;
            }
        }

        boolean isEmpty() {
            return stack.isEmpty();
        }

        TreeNode peek() {
            return stack.peek();
        }

        void pop() {
            TreeNode node = stack.pop().right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
    }
}
