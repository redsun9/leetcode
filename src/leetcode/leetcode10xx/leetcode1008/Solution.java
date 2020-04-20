package leetcode.leetcode10xx.leetcode1008;

import leetcode.tools.TreeNode;

import java.util.Stack;

public class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        Stack<Integer> values = new Stack<>();
        Stack<TreeNode> stack = new Stack<>();
        values.push(Integer.MAX_VALUE);
        stack.push(root);
        for (int i = 1; i < preorder.length; i++) {
            while (values.peek() < preorder[i]) {
                stack.pop();
                values.pop();
            }
            if (preorder[i] < stack.peek().val) {
                TreeNode node = new TreeNode(preorder[i]);
                stack.peek().left = node;
                values.push(stack.peek().val);
                stack.push(node);
            } else {
                TreeNode node = new TreeNode(preorder[i]);
                stack.peek().right = node;
                values.push(values.peek());
                stack.push(node);
            }
        }
        return root;
    }
}
