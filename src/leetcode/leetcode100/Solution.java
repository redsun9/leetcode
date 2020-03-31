package leetcode.leetcode100;

import java.util.Stack;

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == null && q == null;
        Stack<TreeNode> first = new Stack<>();
        Stack<TreeNode> second = new Stack<>();
        first.push(p);
        second.push(q);
        while (!first.isEmpty()) {
            TreeNode a = first.pop();
            TreeNode b = second.pop();
            if (a.val != b.val) return false;
            if (a.left != null || b.left != null) {
                if (a.left != null ^ b.left != null) return false;
                first.push(a.left);
                second.push(b.left);
            }
            if (a.right != null || b.right != null) {
                if (a.right != null ^ b.right != null) return false;
                first.push(a.right);
                second.push(b.right);
            }
        }
        return true;
    }
}
