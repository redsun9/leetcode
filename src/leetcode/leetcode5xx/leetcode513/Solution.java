package leetcode.leetcode5xx.leetcode513;

import leetcode.tools.TreeNode;

import java.util.LinkedList;

public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        int ans = root.val;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            ans = queue.peekFirst().val;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pollFirst();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return ans;
    }
}
