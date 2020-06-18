package suggestions.similar_path;

import basic.ArrayTools;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
