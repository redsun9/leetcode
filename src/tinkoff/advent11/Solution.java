package tinkoff.advent11;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

@SuppressWarnings({"DuplicatedCode", "ConstantConditions", "unchecked"})
public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/tinkoff/advent11/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/tinkoff/advent11/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            int n = Integer.parseInt(scanner.nextLine());

            int[] indegree = new int[n];
            List<Integer>[] adj = new List[n];
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

            for (int v = 0; v < n; v++) {
                int m = scanner.nextInt();
                indegree[v] = m;
                if (m == 0) pq.offer(v);
                for (int j = 0; j < m; j++) {
                    int u = scanner.nextInt() - 1;
                    adj[u].add(v);
                }
            }

            long ans = 0;

            for (int i = 1; i <= n; i++) {
                Integer u = pq.poll();
                ans += i * (u + 1L);
                for (Integer v : adj[u]) if (--indegree[v] == 0) pq.offer(v);
            }

            printer.println(ans);
        }
    }
}
