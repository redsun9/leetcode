package leetcode.leetcode6xx.leetcode653;

import leetcode.tools.TreeNode;

import java.util.Stack;

public class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Stack<TreeNode> lo = new Stack<>();
        Stack<TreeNode> hi = new Stack<>();
        for (TreeNode tmp = root; tmp != null; tmp = tmp.left) lo.push(tmp);
        for (TreeNode tmp = root; tmp != null; tmp = tmp.right) hi.push(tmp);

        while (lo.peek().val != hi.peek().val) {
            int sum = lo.peek().val + hi.peek().val;
            if (sum == k) return true;
            if (sum < k) {
                for (TreeNode tmp = lo.pop().right; tmp != null; tmp = tmp.left) lo.push(tmp);
            } else {
                for (TreeNode tmp = hi.pop().left; tmp != null; tmp = tmp.right) hi.push(tmp);
            }
        }
        return lo.peek() != hi.peek() && lo.peek().val + hi.peek().val == k;
    }
}
