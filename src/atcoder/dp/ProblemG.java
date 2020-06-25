package atcoder.dp;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ProblemG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<Integer>[] incoming = new List[n];
        int[] outcoming = new int[n];
        for (int i = 0; i < n; i++) incoming[i] = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt() - 1;
            int v = scanner.nextInt() - 1;
            outcoming[u]++;
            incoming[v].add(u);
        }

        int[] dp = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (outcoming[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            int curVal = dp[poll];
            for (Integer neighbor : incoming[poll]) {
                outcoming[neighbor]--;
                dp[neighbor] = Math.max(dp[neighbor], curVal + 1);
                if (outcoming[neighbor] == 0) queue.add(neighbor);

            }
        }
        int ans = 0;
        for (int a : dp) ans = Math.max(ans, a);
        System.out.println(ans);
    }
}
