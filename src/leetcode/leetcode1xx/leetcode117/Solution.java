package leetcode.leetcode1xx.leetcode117;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("ConstantConditions")
public class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        int currentRowSize = 1;
        int nextRowSize;
        queue.add(root);
        Node previous, next;
        while (currentRowSize != 0) {
            previous = queue.poll();
            nextRowSize = 0;
            if (previous.left != null) {
                nextRowSize++;
                queue.add(previous.left);
            }
            if (previous.right != null) {
                nextRowSize++;
                queue.add(previous.right);
            }
            currentRowSize--;
            while (currentRowSize > 0) {
                next = queue.poll();
                if (next.left != null) {
                    nextRowSize++;
                    queue.add(next.left);
                }
                if (next.right != null) {
                    nextRowSize++;
                    queue.add(next.right);
                }
                previous.next = next;
                previous = next;
                currentRowSize--;
            }
            currentRowSize = nextRowSize;
        }
        return root;
    }
}
