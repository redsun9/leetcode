package leetcode.leetcode22xx.leetcode2242;

public class Solution {
    public int maximumScore(int[] scores, int[][] edges) {
        int n = scores.length;
        int[][][] maxNeighbors = new int[n][3][2];
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            process(maxNeighbors[u], v, scores[v]);
            process(maxNeighbors[v], u, scores[u]);
        }
        int ans = -1;
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            for (int[] a : maxNeighbors[u]) {
                if (a[0] == 0 || a[1] == v) continue;
                for (int[] b : maxNeighbors[v]) {
                    if (b[0] == 0 || b[1] == u || b[1] == a[1]) continue;
                    int score = scores[u] + scores[v] + a[0] + b[0];
                    ans = Math.max(ans, score);
                }
            }
        }
        return ans;
    }

    private static void process(int[][] max, int v, int score) {
        if (score > max[0][0]) {
            max[2] = max[1];
            max[1] = max[0];
            max[0] = new int[]{score, v};
        } else if (score > max[1][0]) {
            max[2] = max[1];
            max[1] = new int[]{score, v};
        } else if (score > max[2][0]) {
            max[2] = new int[]{score, v};
        }
    }
}
