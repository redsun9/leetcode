package leetcode.leetcode1xx.leetcode103;

import leetcode.tools.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

@SuppressWarnings("ConstantConditions")
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        boolean forward = true;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int genSize = queue.size();
            List<Integer> list = new ArrayList<>(genSize);
            if (forward) {
                for (int i = 0; i < genSize; i++) {
                    TreeNode node = queue.pollFirst();
                    list.add(node.val);
                    if (node.left != null) queue.addLast(node.left);
                    if (node.right != null) queue.addLast(node.right);
                }
            } else {
                for (int i = 0; i < genSize; i++) {
                    TreeNode node = queue.pollLast();
                    list.add(node.val);
                    if (node.right != null) queue.addFirst(node.right);
                    if (node.left != null) queue.addFirst(node.left);
                }
            }
            ans.add(list);
            forward = !forward;
        }
        return ans;
    }
}
