package basic.utils;

import leetcode.tools.TreeNode;

import java.util.Stack;

public class TreeTools {
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

        int peek() {
            return stack.peek().val;
        }

        void pop() {
            TreeNode node = stack.pop().right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
    }

    static class BstDecreasingIterator {
        private final Stack<TreeNode> stack = new Stack<>();

        BstDecreasingIterator(TreeNode root, double target) {
            while (root != null) {
                if (root.val <= target) {
                    stack.push(root);
                    root = root.right;
                } else root = root.left;
            }
        }

        boolean isEmpty() {
            return stack.isEmpty();
        }

        int peek() {
            return stack.peek().val;
        }

        void pop() {
            TreeNode node = stack.pop().left;
            while (node != null) {
                stack.push(node);
                node = node.right;
            }
        }
    }
}
