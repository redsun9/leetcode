package leetcode.leetcode1xx.leetcode145;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node.left != null)
                    stack.add(node.left);
                if (node.right != null)
                    stack.add(node.right);
                result.addFirst(node.val);
            }
        }
        return result;
    }
}
