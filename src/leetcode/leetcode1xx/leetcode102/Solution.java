package leetcode.leetcode1xx.leetcode102;

import leetcode.tools.TreeNode;

import java.util.*;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int currentGeneration = 1;
        int nextGeneration = 0;
        List<Integer> subAns = new ArrayList<>(currentGeneration);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            subAns.add(poll.val);
            if (poll.left != null) {
                queue.offer(poll.left);
                nextGeneration++;
            }
            if (poll.right != null) {
                queue.offer(poll.right);
                nextGeneration++;
            }
            currentGeneration--;
            if (currentGeneration == 0) {
                ans.add(subAns);
                currentGeneration = nextGeneration;
                nextGeneration = 0;
                subAns = new ArrayList<>(currentGeneration);
            }
        }
        return ans;
    }
}
