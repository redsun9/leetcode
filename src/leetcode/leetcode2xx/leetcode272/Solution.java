package leetcode.leetcode2xx.leetcode272;

import leetcode.tools.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> ans = new ArrayList<>(k);
        BstIncreasingIterator inc = new BstIncreasingIterator(root, target);
        BstDecreasingIterator dec = new BstDecreasingIterator(root, target);
        if (!inc.isEmpty() && !dec.isEmpty() && inc.peek() == dec.peek()) {
            ans.add(dec.peek());
            inc.pop();
            dec.pop();
            k--;
        }
        while (k-- > 0) {
            if (inc.isEmpty()) {
                ans.add(dec.peek());
                dec.pop();
            } else if (dec.isEmpty()) {
                ans.add(inc.peek());
                inc.pop();
            } else if (Math.abs(target - inc.peek()) <= Math.abs(target - dec.peek())) {
                ans.add(inc.peek());
                inc.pop();
            } else {
                ans.add(dec.peek());
                dec.pop();
            }
        }
        return ans;
    }

    private static class BstIncreasingIterator {
        private final Stack<TreeNode> stack = new Stack<>();

        BstIncreasingIterator(TreeNode root, double target) {
            while (root != null) {
                if (root.val >= target) {
                    stack.push(root);
                    root = root.left;
                } else root = root.right;
            }
        }

        boolean isEmpty() {
            return stack.isEmpty();
        }

        int peek() {
            return stack.peek().val;
        }

        void pop() {
            TreeNode node = stack.pop().right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
    }

    private static class BstDecreasingIterator {
        private final Stack<TreeNode> stack = new Stack<>();

        BstDecreasingIterator(TreeNode root, double target) {
            while (root != null) {
                if (root.val <= target) {
                    stack.push(root);
                    root = root.right;
                } else root = root.left;
            }
        }

        boolean isEmpty() {
            return stack.isEmpty();
        }

        int peek() {
            return stack.peek().val;
        }

        void pop() {
            TreeNode node = stack.pop().left;
            while (node != null) {
                stack.push(node);
                node = node.right;
            }
        }
    }
}
