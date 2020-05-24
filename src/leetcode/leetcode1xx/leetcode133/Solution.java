package leetcode.leetcode1xx.leetcode133;

import java.util.ArrayList;
import java.util.List;


//without additional memory
public class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        first(node);
        Node ans = node.neighbors.get(0);
        second(node);
        third(node);
        fourth(node);
        return ans;
    }
    //negative valuse as used==true

    private static void first(Node original) {
        if (original.val < 0) return;
        Node copy = new Node(original.val);
        copy.neighbors = original.neighbors;
        original.neighbors = new ArrayList<>();
        original.neighbors.add(copy);
        original.val = -original.val;
        for (Node neighbor : copy.neighbors) {
            first(neighbor);
        }
    }

    private static void second(Node original) {
        if (original.val > 0) return;
        Node copyNode = original.neighbors.get(0);
        List<Node> originalNeighbors = copyNode.neighbors;
        List<Node> copyNeighbors = new ArrayList<>(originalNeighbors.size());
        for (Node originalNeighbor : originalNeighbors) {
            copyNeighbors.add(originalNeighbor.neighbors.get(0));
        }
        copyNode.neighbors = copyNeighbors;
        original.neighbors.addAll(originalNeighbors);
        original.val = -original.val;
        for (Node originalNeighbor : originalNeighbors) {
            second(originalNeighbor);
        }
    }

    private static void third(Node original) {
        if (original.val < 0) return;
        original.neighbors.remove(0);
        original.val = -original.val;
        for (Node neighbor : original.neighbors) {
            third(neighbor);
        }
    }

    private static void fourth(Node original) {
        if (original.val > 0) return;
        original.val = -original.val;
        for (Node neighbor : original.neighbors) {
            fourth(neighbor);
        }
    }
}
