package leetcode.leetcode1xx.leetcode116;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        int currentGeneration = 1;
        int nextGeneration = 0;
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            currentGeneration--;
            if (poll.left != null) {
                queue.add(poll.left);
                nextGeneration++;
            }
            if (poll.right != null) {
                queue.add(poll.right);
                nextGeneration++;
            }
            if (currentGeneration != 0) {
                poll.next = queue.peek();
            } else {
                currentGeneration = nextGeneration;
                nextGeneration = 0;
            }
        }
        return root;
    }
}
