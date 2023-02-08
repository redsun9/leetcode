package help_requests.even_number_of_edges;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    //max number of edges that can be left in the graph after removing some vertices to make the number of edges even
    public int maxNumberOfEdges(int[][] edges) {
        int n = edges.length;
        if (n % 2 == 0) return n;
        HashMap<Integer, Integer> degreeMap = new HashMap<>();
        for (int[] edge : edges) {
            degreeMap.compute(edge[0], (k, v) -> v == null ? 1 : v + 1);
            degreeMap.compute(edge[1], (k, v) -> v == null ? 1 : v + 1);
        }
        int minDelete = n;
        for (int degree : degreeMap.values()) if (degree % 2 == 1) minDelete = Math.min(minDelete, degree);

        for (int[] edge : edges) {
            if (degreeMap.get(edge[0]) % 2 == 0 && degreeMap.get(edge[1]) % 2 == 0) {
                minDelete = Math.min(minDelete, degreeMap.get(edge[0]) + degreeMap.get(edge[1]) - 1);
            }
        }
        return n - minDelete;
    }


    //max sum of edges that can be left in the graph after removing some vertices to make the number of edges even
    // no duplicate edges in the graph or self-referencing edges
    public long maxSumOfEdges(int[][] edges) {
        long totalSum = 0;
        for (int[] edge : edges) totalSum += edge[2];

        int n = edges.length;
        if (n % 2 == 0) return totalSum;
        HashMap<Integer, Integer> verticeNumberOfEdges = new HashMap<>();
        HashMap<Integer, Long> verticeSumOfEdges = new HashMap<>();
        for (int[] edge : edges) {
            verticeNumberOfEdges.compute(edge[0], (k, v) -> v == null ? 1 : v + 1);
            verticeNumberOfEdges.compute(edge[1], (k, v) -> v == null ? 1 : v + 1);
            verticeSumOfEdges.compute(edge[0], (k, v) -> v == null ? edge[2] : v + edge[2]);
            verticeSumOfEdges.compute(edge[1], (k, v) -> v == null ? edge[2] : v + edge[2]);
        }
        long minDelete = totalSum;
        for (Map.Entry<Integer, Integer> degree : verticeNumberOfEdges.entrySet()) {
            if (degree.getValue() % 2 == 1) minDelete = Math.min(minDelete, verticeSumOfEdges.get(degree.getKey()));
        }

        for (int[] edge : edges) {
            if (verticeNumberOfEdges.get(edge[0]) % 2 == 0 && verticeNumberOfEdges.get(edge[1]) % 2 == 0) {
                minDelete = Math.min(minDelete, verticeSumOfEdges.get(edge[0]) + verticeSumOfEdges.get(edge[1]) - edge[2]);
            }
        }
        return totalSum - minDelete;
    }

    //max sum of edges that can be left in the graph after removing some vertices to make the number of edges even
    // duplicate edges are allowed in the graph and also self-referencing edges
    public long maxSumOfEdgesWhenDuplicatesAndSelfEdgesAllowed(int[][] edges) {
        long totalSum = 0;
        for (int[] edge : edges) totalSum += edge[2];

        int n = edges.length;
        if (n % 2 == 0) return totalSum;
        HashMap<Integer, Integer> verticeCount = new HashMap<>();
        HashMap<Integer, Long> verticeSum = new HashMap<>();
        HashMap<Pair, Integer> edgeCount = new HashMap<>();
        HashMap<Pair, Long> edgeSum = new HashMap<>();

        for (int[] edge : edges) {
            verticeCount.compute(edge[0], (k, value) -> value == null ? 1 : value + 1);
            verticeSum.compute(edge[0], (k, value) -> value == null ? edge[2] : value + edge[2]);
            if (edge[0] != edge[1]) {
                verticeCount.compute(edge[1], (k, value) -> value == null ? 1 : value + 1);
                verticeSum.compute(edge[1], (k, value) -> value == null ? edge[2] : value + edge[2]);
                Pair pair = new Pair(Math.min(edge[0], edge[1]), Math.max(edge[0], edge[1]));
                edgeCount.compute(pair, (k, value) -> value == null ? 1 : value + 1);
                edgeSum.compute(pair, (k, value) -> value == null ? edge[2] : value + edge[2]);
            }
        }
        long minDelete = totalSum;
        for (Map.Entry<Integer, Integer> entry : verticeCount.entrySet()) {
            if (entry.getValue() % 2 == 1) minDelete = Math.min(minDelete, verticeSum.get(entry.getKey()));
        }


        for (Map.Entry<Pair, Integer> entry : edgeCount.entrySet()) {
            Integer value = entry.getValue();
            Pair key = entry.getKey();
            if (value % 2 == 1 && verticeCount.get(key.u) % 2 == 0 && verticeCount.get(key.v) % 2 == 0) {
                minDelete = Math.min(minDelete, verticeSum.get(key.u) + verticeSum.get(key.v) - edgeSum.get(key));
            }
        }
        return totalSum - minDelete;
    }

    private record Pair(int u, int v) {
    }
}
