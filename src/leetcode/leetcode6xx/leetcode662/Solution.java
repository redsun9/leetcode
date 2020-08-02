package leetcode.leetcode6xx.leetcode662;

import leetcode.tools.TreeNode;

import java.util.LinkedList;

public class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        LinkedList<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, root));
        long ans = 0;
        while (!queue.isEmpty()) {
            long shift = queue.getFirst().pos;
            ans = Math.max(ans, queue.getLast().pos - shift);
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Pair pair = queue.pollFirst();
                if (pair.node.left != null) {
                    queue.addLast(new Pair((pair.pos - shift) * 2, pair.node.left));
                }
                if (pair.node.right != null) {
                    queue.addLast(new Pair((pair.pos - shift) * 2 + 1, pair.node.right));
                }
            }
        }
        return (int) (ans + 1);
    }

    private static final class Pair {
        long pos;
        TreeNode node;

        public Pair(long pos, TreeNode node) {
            this.pos = pos;
            this.node = node;
        }
    }
}

