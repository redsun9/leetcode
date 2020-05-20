package leetcode.leetcode10xx.leetcode1028;

import leetcode.tools.TreeNode;

import java.util.Stack;

public class Solution {
    public TreeNode recoverFromPreorder(String s) {
        if (s == null || s.isEmpty()) return null;
        int n = s.length();
        int number = 0;
        int i = 0;
        while (i < n && Character.isDigit(s.charAt(i)))
            number = number * 10 + s.charAt(i++) - '0';
        TreeNode root = new TreeNode(number);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (i < n) {
            int depth = 0;
            while (i < n && s.charAt(i) == '-') {
                i++;
                depth++;
            }
            number = 0;
            while (i < n && Character.isDigit(s.charAt(i)))
                number = number * 10 + s.charAt(i++) - '0';
            TreeNode child = new TreeNode(number);
            while (stack.size() > depth) stack.pop();
            TreeNode parent = stack.peek();
            if (parent.left == null) parent.left = child;
            else parent.right = child;
            stack.push(child);
        }
        return root;
    }

}
