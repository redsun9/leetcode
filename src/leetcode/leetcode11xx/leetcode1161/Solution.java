package leetcode.leetcode11xx.leetcode1161;

import leetcode.tools.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

@SuppressWarnings("ConstantConditions")
public class Solution {
    public int maxLevelSum(TreeNode root) {
        int maxSum = root.val, ans = 1;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int level = 0, levelSize, levelSum;
        while (!queue.isEmpty()) {
            level++;
            levelSize = queue.size();
            levelSum = 0;
            while (levelSize-- != 0) {
                root = queue.poll();
                levelSum += root.val;
                if (root.left != null) queue.add(root.left);
                if (root.right != null) queue.add(root.right);
            }
            if (levelSum > maxSum) {
                ans = level;
                maxSum = levelSum;
            }
        }
        return ans;
    }
}
