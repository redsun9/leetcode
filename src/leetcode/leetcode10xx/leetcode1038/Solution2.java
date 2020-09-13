package leetcode.leetcode10xx.leetcode1038;

import leetcode.tools.TreeNode;

import java.util.Stack;

public class Solution2 {
    public TreeNode bstToGst(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = root;
        while (tmp != null) {
            stack.push(tmp);
            tmp = tmp.right;
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            tmp = stack.pop();
            sum += tmp.val;
            tmp.val = sum;
            tmp = tmp.left;
            while (tmp != null) {
                stack.push(tmp);
                tmp = tmp.right;
            }
        }
        return root;
    }
}
