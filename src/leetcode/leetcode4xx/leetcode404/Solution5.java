package leetcode.leetcode4xx.leetcode404;

import leetcode.tools.TreeNode;

import java.util.Stack;

public class Solution5 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        int ans = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (node.left != null && node.left.left == null && node.left.right == null)
                    ans += node.left.val;
                stack.push(node.left);
                stack.push(node.right);
            }
        }
        return ans;
    }
}
