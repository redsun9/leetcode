package leetcode.leetcode4xx.leetcode428;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.parseInt;

public class Solution {
    public String serialize(ArrayList<DirectedGraphNode> nodes) {
        if (nodes.isEmpty()) return null;
        if (nodes.size() == 1) return Integer.toString(nodes.get(0).label);
        StringBuilder sb = new StringBuilder();
        for (DirectedGraphNode node : nodes) {
            if (node.neighbors.isEmpty()) continue;
            sb.append('#').append(node.label);
            for (DirectedGraphNode nb : node.neighbors) sb.append(',').append(nb.label);
        }
        return sb.substring(1);
    }

    public UndirectedGraphNode deserialize(String data) {
        if (data == null) return null;
        String[] parts = data.split("#");
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        for (String part : parts) {
            String[] split = part.split(",");
            int from = parseInt(split[0]);
            inDegree.putIfAbsent(from, 0);
            UndirectedGraphNode u = map.computeIfAbsent(from, UndirectedGraphNode::new);
            for (int i = 1; i < split.length; i++) {
                int to = parseInt(split[i]);
                u.neighbors.add(map.computeIfAbsent(to, UndirectedGraphNode::new));
                inDegree.compute(to, (k, v) -> v == null ? 1 : v + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) return map.get(entry.getKey());
        }
        return null;
    }
}
