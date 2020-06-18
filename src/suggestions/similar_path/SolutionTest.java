package suggestions.similar_path;

import basic.ArrayTools;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SolutionTest {

    @Test
    void test1() {
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
        int[] target = {0, 1, 5, 3, 4};
        int[] actual = new Solution().similarPath(5, edges, target);
        assertEquals(distance(target, new int[]{0, 1, 2, 3, 4}), distance(target, actual));
    }

    @Test
    void test2() {
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
        int[] target = {0, 6, 5, 3, 4};
        int[] actual = new Solution().similarPath(5, edges, target);
        assertEquals(distance(target, new int[]{0, 1, 2, 3, 4}), distance(target, actual));
    }

    @Test
    void test3() {
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}, {4, 5}};
        int[] target = {0, 1, 2, 3, 4, 5};
        int[] actual = new Solution().similarPath(6, edges, target);
        assertEquals(distance(target, new int[]{0, 1, 2}), distance(target, actual));
    }

    @Test
    void test4() {
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {3, 4}};
        int[] target = {0, 4, 3, 4};
        int[] actual = new Solution().similarPath(6, edges, target);
        assertEquals(distance(target, new int[]{0, 1, 3, 4}), distance(target, actual));
    }

    @Test
    void test5() {
        int[][] edges = {
                {0, 1}, {0, 2}, {1, 2},
                {3, 4}, {3, 5}, {3, 6}, {4, 5}, {4, 6}, {5, 6}
        };
        int[] target = {0, 1, 2, 3, 4, 5, 6};
        for (int i = 0; i < 1000; i++) {
            ArrayTools.shuffle(target);
            int[] expected = new int[4];
            int pos = 0;
            for (int value : target) if (value >= 3 && value <= 6) expected[pos++] = value;
            int[] actual = new Solution().similarPath(7, edges, target);
            assertEquals(distance(target, expected), distance(target, actual));
        }
    }

    @Test
    void test6() {
        int[][] edges = {
                {0, 1}, {0, 2}, {1, 2},
                {3, 4}, {3, 5}, {3, 6}, {4, 5}, {4, 6}, {5, 6}
        };
        int[] target = {1, 4, 3, 2, 0, 5, 6};
        int[] actual = new Solution().similarPath(7, edges, target);
        assertEquals(distance(target, new int[]{3, 4, 3, 4, 3, 5, 6}), distance(target, actual));
    }

    @Test
    void perfTest() {
        Random random = new Random(0);
        int nTests = 1_000;
        int nVertices = 1_000;
        int nEdges = 10_000;
        int nTarget = 100;
        double pExist = 0.9;

        int[][][] edges = new int[nTests][nEdges][2];
        for (int t = 0; t < nTests; t++) {
            for (int i = 0; i < nEdges; ) {
                int u = random.nextInt(nVertices);
                int v = random.nextInt(nVertices);
                if (u != v) {
                    edges[t][i][0] = u;
                    edges[t][i][1] = v;
                    i++;
                }
            }
        }
        int[][] target = new int[nTests][nTarget];
        for (int t = 0; t < nTests; t++) {
            int prevTarget = -1;
            for (int i = 0; i < nTarget; ) {
                if (random.nextDouble() < pExist) {
                    int u = random.nextInt(nVertices);
                    if (prevTarget != u) target[t][i++] = u;
                    prevTarget = u;
                } else {
                    target[t][i++] = nVertices;
                }
            }
        }
        Solution solution = new Solution();

        long start = System.nanoTime();
        IntStream.range(0, nTests).parallel().forEach(i -> {
            int[] path = solution.similarPath(nVertices, edges[i], target[i]);
            assertNotNull(path);
        });
        long end = System.nanoTime();
        System.out.println((end - start) / 1e9);
    }

    private static final int distance(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) dp[i][0] = i;
        for (int j = 1; j <= n; j++) dp[0][j] = j;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i + 1][j + 1] = min(dp[i][j + 1], dp[i + 1][j], dp[i][j] + (a[i] == b[j] ? 0 : 1));
            }
        }
        return dp[m][n];
    }

    private static int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
