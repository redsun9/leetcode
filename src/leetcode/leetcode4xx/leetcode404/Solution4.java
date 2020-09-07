package leetcode.leetcode4xx.leetcode404;

import leetcode.tools.TreeNode;

import java.util.Stack;

public class Solution4 {
    public int sumOfLeftLeaves(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        int ans = 0;
        while (!stack.isEmpty()) {
            root = stack.pop();
            if (root.left != null && root.left.left == null && root.left.right == null) ans += root.left.val;
            root = root.right;
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }
        return ans;
    }
}
