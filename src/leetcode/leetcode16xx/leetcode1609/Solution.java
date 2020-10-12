package leetcode.leetcode16xx.leetcode1609;

import leetcode.tools.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int currentGeneration = 1;
        boolean evenLevel = true;
        int prevValue = Integer.MIN_VALUE;
        while (true) {
            while (currentGeneration-- != 0) {
                root = queue.poll();
                if (
                        prevValue == root.val
                                || (evenLevel ^ (prevValue < root.val))
                                || (root.val % 2 != 0 ^ evenLevel)
                ) return false;
                if (root.left != null) queue.offer(root.left);
                if (root.right != null) queue.offer(root.right);
                prevValue = root.val;
            }
            currentGeneration = queue.size();
            evenLevel = !evenLevel;
            prevValue = evenLevel ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            if (currentGeneration == 0) return true;
        }
    }
}
