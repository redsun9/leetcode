package leetcode.leetcode24xx.leetcode2415;

import leetcode.tools.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> prev = new ArrayDeque<>(), next = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();
        prev.offer(root);
        TreeNode node;
        while (!prev.isEmpty()) {
            while (!prev.isEmpty()) {
                node = prev.poll();
                if (node.left != null) {
                    next.add(node.left);
                    stack.push(node.left.val);
                }
                if (node.right != null) {
                    next.add(node.right);
                    stack.push(node.right.val);
                }
            }
            while (!next.isEmpty()) {
                node = next.poll();
                node.val = stack.pop();
                if (node.left != null) prev.add(node.left);
                if (node.right != null) prev.add(node.right);
            }
        }
        return root;
    }
}
