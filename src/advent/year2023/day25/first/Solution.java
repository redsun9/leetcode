package advent.year2023.day25.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

import static java.util.stream.IntStream.range;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2023/day25/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2023/day25/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            List<Edge> input = parseInput(scanner);
            checkInput(input);
            printer.println(solve(input));
        }
    }

    private static List<Edge> parseInput(Scanner scanner) {
        List<Edge> input = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine().trim();
            if (s.isBlank()) continue;
            String[] split = s.split("[: ]+");
            for (int i = 1; i < split.length; i++) input.add(new Edge(split[0], split[i]));
        }
        return input;
    }

    private static void checkInput(List<Edge> input) {
        Map<String, Set<String>> adj = new HashMap<>();
        for (Edge edge : input) {
            adj.computeIfAbsent(edge.a, key -> new HashSet<>()).add(edge.b);
            adj.computeIfAbsent(edge.b, key -> new HashSet<>()).add(edge.a);
        }

        for (Map.Entry<String, Set<String>> entry : adj.entrySet()) {
            if (entry.getValue().size() <= 3) System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println("vertices = " + adj.size());
        System.out.println("edges = " + input.size());

        for (Edge edge : input) {
            String a = edge.a, b = edge.b;
            Set<String> set = adj.get(b);
            int connectivityBetween = 1;
            for (String c : adj.get(a)) {
                if (b.equals(c)) continue;
                if (set.contains(c)) connectivityBetween++;
            }
            if (connectivityBetween >= 4) System.out.println(a + " " + b + " has " + connectivityBetween);
        }
    }

    private static long solve(List<Edge> input) {
        Map<String, Integer> vertexIdxMap = new HashMap<>();
        for (Edge edge : input) {
            if (!vertexIdxMap.containsKey(edge.a)) vertexIdxMap.put(edge.a, vertexIdxMap.size());
            if (!vertexIdxMap.containsKey(edge.b)) vertexIdxMap.put(edge.b, vertexIdxMap.size());
        }

        int n = vertexIdxMap.size();
        int[][] graph = new int[n][n];
        for (Edge edge : input) {
            int u = vertexIdxMap.get(edge.a), v = vertexIdxMap.get(edge.b);
            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        long count1 = range(1, n - 1).parallel()
                .filter(x -> FordFulkerson.fordFulkerson(graph, 0, x) >= 4)
                .count() + 1;

        return count1 * (n - count1);
    }

    private record Edge(String a, String b) {
    }
}
