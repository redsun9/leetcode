package leetcode.leetcode101;

import java.util.Stack;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> first = new Stack<>();
        Stack<TreeNode> second = new Stack<>();
        if (root.left != null ^ root.right != null) return false;
        if (root.left != null) {
            first.push(root.left);
            second.push(root.right);
        }
        while (!first.isEmpty()) {
            TreeNode a = first.pop();
            TreeNode b = second.pop();
            if (a.val != b.val) return false;
            if (a.left != null || b.right != null) {
                if (a.left != null ^ b.right != null) return false;
                first.push(a.left);
                second.push(b.right);
            }
            if (a.right != null || b.left != null) {
                if (a.right != null ^ b.left != null) return false;
                first.push(a.right);
                second.push(b.left);
            }
        }
        return true;
    }
}
