package leetcode.leetcode112;

import java.util.Stack;

public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        Stack<CustomNode> stack = new Stack<>();
        stack.add(new CustomNode(root, 0));
        while (!stack.isEmpty()) {
            CustomNode pop = stack.pop();
            if (pop.node.left != null || pop.node.right != null) {
                if (pop.node.left != null) {
                    stack.push(new CustomNode(pop.node.left, pop.pathSum + pop.node.val));
                }
                if (pop.node.right != null) {
                    stack.push(new CustomNode(pop.node.right, pop.pathSum + pop.node.val));
                }
            } else {
                if (pop.pathSum + pop.node.val == sum) return true;
            }
        }
        return false;
    }

    private static class CustomNode {
        TreeNode node;
        int pathSum;

        public CustomNode(TreeNode node, int pathSum) {
            this.node = node;
            this.pathSum = pathSum;
        }
    }
}
