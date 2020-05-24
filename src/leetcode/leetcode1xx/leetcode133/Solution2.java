package leetcode.leetcode1xx.leetcode133;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

public class Solution2 {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (!map.containsKey(poll)) {
                map.put(poll, new Node(poll.val));
                queue.addAll(poll.neighbors);
            }
        }
        map.forEach((orig, copy) -> orig.neighbors.forEach(neigh -> copy.neighbors.add(map.get(neigh))));
        return map.get(node);
    }
}
