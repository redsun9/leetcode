package leetcode.leetcode13xx.leetcode1373;

import leetcode.tools.TreeNode;

import java.util.Stack;

public class Solution {
    private static final boolean isDebug = true;

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
                peek.process();
                if (peek.isValid) {
                    maxValue = Math.max(maxValue, peek.sum);
                }
                stack.pop();
            }
        }
        return maxValue;
    }

    private static class StackNode {
        TreeNode node;
        boolean seen;
        boolean isValid;
        int sum, minValue, maxValue;
        StackNode left, right;

        public StackNode(TreeNode node) {
            this.node = node;
        }


        public void process() {
            isValid = true;
            sum = node.val;
            minValue = node.val;
            maxValue = node.val;
            if (left != null) {
                if (left.maxValue >= node.val || !left.isValid) {
                    isValid = false;
                    return;
                }
                sum += left.sum;
                minValue = left.minValue;
            }
            if (right != null) {
                if (right.minValue <= node.val || !right.isValid) {
                    isValid = false;
                    return;
                }
                sum += right.sum;
                maxValue = right.maxValue;
            }
        }

        @Override
        public String toString() {
            return Integer.toString(node.val);
        }
    }
}
