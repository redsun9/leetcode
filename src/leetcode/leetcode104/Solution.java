package leetcode.leetcode104;

import java.util.Stack;

public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Stack<CustomNode> stack = new Stack<>();
        stack.add(new CustomNode(root, 1));
        int depth = 0;
        while (!stack.isEmpty()) {
            CustomNode node = stack.pop();
            if (node.node.left == null && node.node.right == null) depth = Math.max(depth, node.depth);
            else {
                if (node.node.left != null) stack.push(new CustomNode(node.node.left, node.depth + 1));
                if (node.node.right != null) stack.push(new CustomNode(node.node.right, node.depth + 1));
            }
        }
        return depth;
    }


    private static class CustomNode {
        TreeNode node;
        int depth;

        public CustomNode(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}
