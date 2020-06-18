package leetcode.leetcode14xx.leetcode1485;

import java.util.ArrayDeque;
import java.util.IdentityHashMap;
import java.util.Queue;

// strait-forward solution
public class Solution2 {
    public NodeCopy copyRandomBinaryTree(Node node) {
        if (node == null) return null;
        IdentityHashMap<Node, NodeCopy> map = new IdentityHashMap<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            map.put(poll, new NodeCopy(poll.val));
            if (poll.left != null) queue.add(poll.left);
            if (poll.right != null) queue.add(poll.right);
        }
        map.forEach((orig, copy) -> {
            copy.left = orig.left != null ? map.get(orig.left) : null;
            copy.right = orig.right != null ? map.get(orig.right) : null;
            copy.random = orig.random != null ? map.get(orig.random) : null;
        });
        return map.get(node);
    }
}
