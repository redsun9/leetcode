package facebook.hacker2021.qual.ProblemC2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

@SuppressWarnings({"unchecked", "UnnecessarySemicolon", "DuplicatedCode"})
public class Main {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/facebook/hacker2021/qual/ProblemC2/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/facebook/hacker2021/qual/ProblemC2/output.txt");
                PrintStream printer = new PrintStream(fos);
        ) {
            int numberOfTests = scanner.nextInt();
            for (int test = 1; test <= numberOfTests; test++) {
                int n = scanner.nextInt(), k = scanner.nextInt();
                int[] g = new int[n];
                for (int i = 0; i < n; i++) g[i] = scanner.nextInt();

                int[][] edges = new int[n - 1][2];
                for (int i = 0; i < n - 1; i++) {
                    edges[i][0] = scanner.nextInt() - 1;
                    edges[i][1] = scanner.nextInt() - 1;
                }
                int ans = solve(k, g, edges);
                printer.println("Case #" + test + ": " + ans);
            }
        }
    }

    private static int solve(int k, int[] g, int[][] edges) {
        final int n = g.length;
        final int maxNeeded = Math.max(n, k) + 1;

        int i, nc, j, a1, a2, x, y, o, d, d2;

        List<Integer>[] adj = new List[n];
        for (i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] edge : edges) {
            x = edge[0];
            y = edge[1];
            adj[x].add(y);
            adj[y].add(x);
        }

        // dp1[k][i][j] = max. value in i's subtree,
        // with j new paths present,
        // and with a free path ongoing from i's parent if k=1
        int[][][] dp1 = new int[2][maxNeeded][maxNeeded];

        // dyn2[k][c][i][j] = max. value after first i children of current node,
        // with j new paths present,
        // and with a free path available for use if k=1,
        // and with at least one child connected if c=1
        int[][][][] dp2 = new int[2][2][maxNeeded][maxNeeded];

        boolean[] processed = new boolean[n];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            i = queue.peekLast();
            if (processed[i]) {
                processed[i] = false;
                queue.pollLast();

                nc = adj[i].size() - (i == 0 ? 0 : 1);

                for (j = 0; j <= nc; j++) {
                    Arrays.fill(dp2[0][0][j], -1);
                    Arrays.fill(dp2[0][1][j], -1);
                    Arrays.fill(dp2[1][0][j], -1);
                    Arrays.fill(dp2[1][1][j], -1);
                }

                dp2[0][0][0][0] = 0;
                nc = 0;
                for (int c : adj[i]) {
                    if (processed[c]) continue;
                    for (a1 = 0; a1 <= k; a1++) {
                        for (x = 0; x < 2; x++) {
                            for (y = 0; y < 2; y++) {
                                if ((d = dp2[x][y][nc][a1]) < 0) continue;
                                for (a2 = 0; a2 <= k - a1; a2++) {
                                    // connect to child
                                    d2 = dp1[1][c][a2];
                                    if (d2 >= 0)
                                        dp2[1 - x][1][nc + 1][a1 + a2 + 1 - x] = Math.max(dp2[1 - x][1][nc + 1][a1 + a2 + 1 - x], d + d2);

                                    // don't connect to child
                                    d2 = dp1[0][c][a2];
                                    if (d2 >= 0)
                                        dp2[x][y][nc + 1][a1 + a2] = Math.max(dp2[x][y][nc + 1][a1 + a2], d + d2);
                                }
                            }
                        }
                    }
                    nc++;
                }

                // combine into main DP
                Arrays.fill(dp1[0][i], -1);
                Arrays.fill(dp1[1][i], -1);

                for (o = 0; o < 2; o++) {
                    for (j = 0; j <= k; j++) {
                        for (x = 0; x < 2; x++) {
                            for (y = 0; y < 2; y++) {
                                if (i == 0 && y == 0) continue;
                                if ((d = dp2[x][y][nc][j]) < 0) continue;
                                if (o != 0 || y != 0) d += g[i];
                                dp1[o][i][j - (o != 0 && x != 0 ? 1 : 0)] = Math.max(dp1[o][i][j - (o != 0 && x != 0 ? 1 : 0)], d);
                            }
                        }
                    }
                }
            } else {
                processed[i] = true;
                for (int c : adj[i]) if (!processed[c]) queue.addLast(c);
            }
        }

        int ans = g[0];
        for (i = 0; i <= k; i++) ans = Math.max(ans, dp1[0][0][i]);
        return ans;
    }
}
