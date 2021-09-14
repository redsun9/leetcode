package leetcode.tools;

import java.util.Stack;

public class MaxSumBST {
    /*
        find subtree with max sum
        subtree can remove it's subtrees, leaves
     */
    public int maxSumBST(TreeNode root) {
        Stack<StackNode> stack = new Stack<>();
        StackNode rootNode = new StackNode(root);
        int maxValue = 0;
        stack.push(rootNode);
        while (!stack.isEmpty()) {
            StackNode peek = stack.peek();
            if (!peek.seen) {
                if (peek.node.left != null) {
                    StackNode leftNode = new StackNode(peek.node.left);
                    peek.left = leftNode;
                    stack.push(leftNode);
                }
                if (peek.node.right != null) {
                    StackNode rightNode = new StackNode(peek.node.right);
                    peek.right = rightNode;
                    stack.push(rightNode);
                }
                peek.seen = true;
            } else {
                peek.cut();
                maxValue = Math.max(maxValue, peek.sum);
                stack.pop();
            }
        }
        return maxValue;
    }

    private static class StackNode {
        TreeNode node;

        @Override
        public String toString() {
            return Integer.toString(node.val);
        }

        int sum;
        boolean seen;
        StackNode left;
        StackNode right;

        public StackNode(TreeNode node) {
            this.node = node;
        }

        public void cut() {
            if (left != null) {
                if (left.node.val >= node.val || left.sum <= 0) left = null;
                if (left != null) left.cutRight(node.val);
            }
            if (right != null) {
                if (right.node.val <= node.val || right.sum <= 0) right = null;
                if (right != null) right.cutLeft(node.val);
            }

            recalculateMaxSum();
        }

        private void cutLeft(int val) {
            if (left != null) {
                if (left.node.val <= val || left.sum <= 0) left = null;
                if (left != null) {
                    left.cutLeft(val);
                }
                recalculateMaxSum();
            }
        }

        private void cutRight(int val) {
            if (right != null) {
                if (right.node.val >= val || right.sum <= 0) right = null;
                if (right != null) {
                    right.cutRight(val);
                }
                recalculateMaxSum();
            }
        }

        private void recalculateMaxSum() {
            sum = node.val + (left != null ? left.sum : 0) + (right != null ? right.sum : 0);
            sum = Math.max(sum, 0);
        }
    }
}
