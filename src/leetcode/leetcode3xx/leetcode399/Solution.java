package leetcode.leetcode3xx.leetcode399;

import java.util.*;

public class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashSet<String> zeros = new HashSet<>();
        HashSet<String> nonZeros = new HashSet<>();
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
        int n = values.length;
        for (int i = 0; i < n; i++) {
            List<String> equation = equations.get(i);
            double value = values[i];
            String firstKey = equation.get(0);
            if (value == 0) zeros.add(firstKey);
            else {
                nonZeros.add(equation.get(0));
                nonZeros.add(equation.get(1));
                HashMap<String, Double> first = graph.getOrDefault(firstKey, new HashMap<>());
                String secondKey = equation.get(1);
                HashMap<String, Double> second = graph.getOrDefault(secondKey, new HashMap<>());
                first.put(secondKey, value);
                second.put(firstKey, 1 / value);
                graph.put(firstKey, first);
                graph.put(secondKey, second);
            }
        }
        int m = queries.size();
        double[] ans = new double[m];
        Arrays.fill(ans, -1);
        for (int i = 0; i < m; i++) {
            List<String> query = queries.get(i);
            String start = query.get(0);
            if (zeros.contains(start)) ans[i] = 0;
            else {
                String finish = query.get(1);
                if (nonZeros.contains(start) && nonZeros.contains(finish)) {
                    HashMap<String, Double> startNeighbours = graph.get(start);
                    HashSet<String> visited = new HashSet<>();
                    Queue<Node> queue = new ArrayDeque<>();
                    queue.add(new Node(start, 1.0));
                    while (!queue.isEmpty()) {
                        Node node = queue.poll();
                        if (node.key.equals(finish)) {
                            ans[i] = node.val;
                            break;
                        }
                        if (visited.contains(node.key)) continue;
                        visited.add(node.key);
                        if (!node.key.equals(start)) {
                            for (Map.Entry<String, Double> entry : graph.get(node.key).entrySet()) {
                                startNeighbours.putIfAbsent(entry.getKey(), node.val * entry.getValue());
                            }
                        }

                        for (Map.Entry<String, Double> entry : graph.get(node.key).entrySet()) {
                            if (!visited.contains(entry.getKey())) {
                                queue.add(new Node(entry.getKey(), node.val * entry.getValue()));
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }

    private static class Node {
        String key;
        double val;

        public Node(String key, double val) {
            this.key = key;
            this.val = val;
        }
    }
}
