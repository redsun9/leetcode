package leetcode.leetcode9xx.leetcode993;

import leetcode.tools.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

@SuppressWarnings("ConstantConditions")
public class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (x == y) return false;
        Queue<TreeNode> queue = new ArrayDeque<>();
        Queue<Integer> parentQueue = new ArrayDeque<>();
        parentQueue.add(0);
        queue.add(root);
        int nextLevelCount = 0;
        int currentLevelCount = 1;
        boolean foundOneOfThem = false;
        int numberOfFound = 0;
        int[] parents = new int[2];
        while (true) {
            TreeNode node = queue.poll();
            Integer parent = parentQueue.poll();
            if (node.val == x || node.val == y) {
                foundOneOfThem = true;
                parents[numberOfFound++] = parent;
                if (numberOfFound == 2) return parents[0] != parents[1];
            }
            currentLevelCount--;
            if (!foundOneOfThem) {
                if (node.left != null) {
                    queue.add(node.left);
                    parentQueue.add(node.val);
                    nextLevelCount++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    parentQueue.add(node.val);
                    nextLevelCount++;
                }
                if (currentLevelCount == 0) {
                    currentLevelCount = nextLevelCount;
                    nextLevelCount = 0;
                }
            } else if (currentLevelCount == 0) return false;
        }
    }
}
