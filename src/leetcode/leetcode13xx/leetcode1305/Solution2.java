package leetcode.leetcode13xx.leetcode1305;

import leetcode.tools.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution2 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ans = new ArrayList<>();
        BSTIterator it1 = new BSTIterator(root1), it2 = new BSTIterator(root2);
        while (it1.hasNext() && it2.hasNext()) {
            if (it1.peek() <= it2.peek()) ans.add(it1.poll());
            else ans.add(it2.poll());
        }
        while (it1.hasNext()) ans.add(it1.poll());
        while (it2.hasNext()) ans.add(it2.poll());
        return ans;
    }


    private static class BSTIterator {
        private final Stack<TreeNode> stack = new Stack<>();

        BSTIterator(TreeNode root) {
            pushAll(root);
        }

        boolean hasNext() {
            return !stack.isEmpty();
        }

        int peek() {
            return stack.peek().val;
        }

        int poll() {
            TreeNode tmpNode = stack.pop();
            pushAll(tmpNode.right);
            return tmpNode.val;
        }

        private void pushAll(TreeNode node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
    }
}
