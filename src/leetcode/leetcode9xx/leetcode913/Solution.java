package leetcode.leetcode9xx.leetcode913;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    private final int MOUSE_TURN = 0;
    private final int CAT_TURN = 1;
    private final Integer DRAW = 0;
    private final Integer MOUSE_WIN = 1;
    private final Integer CAT_WIN = 2;

    public int catMouseGame(int[][] graph) {
        int n = graph.length;

        //(order,mouse,cat)->(0,1,2)
        int[][][] dp = new int[2][n][n];
        //(order,mouse,cat)
        int[][][] count = new int[2][n][n];
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 1; i < n; i++) {
            dp[MOUSE_TURN][i][i] = CAT_WIN;
            dp[CAT_TURN][i][i] = CAT_WIN;
            dp[MOUSE_TURN][0][i] = MOUSE_WIN;
            dp[CAT_TURN][0][i] = MOUSE_WIN;
            queue.offer(new int[]{MOUSE_TURN, i, i});
            queue.offer(new int[]{CAT_TURN, i, i});
            queue.offer(new int[]{MOUSE_TURN, 0, i});
            queue.offer(new int[]{CAT_TURN, 0, i});
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count[MOUSE_TURN][i][j] = graph[i].length;
                count[CAT_TURN][i][j] = graph[j].length;
            }
            for (int j : graph[0]) {
                count[CAT_TURN][i][j]--;
            }
        }

        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            int turn = position[0];
            int mouse = position[1];
            int cat = position[2];
            int result = dp[turn][mouse][cat];
            if (turn == MOUSE_TURN) {
                for (int catFrom : graph[cat]) {
                    if (catFrom == 0) continue;
                    if (dp[CAT_TURN][mouse][catFrom] == DRAW) {
                        if (result == CAT_WIN) dp[CAT_TURN][mouse][catFrom] = CAT_WIN;
                        else if (--count[CAT_TURN][mouse][catFrom] == 0) dp[CAT_TURN][mouse][catFrom] = MOUSE_WIN;
                        if (dp[CAT_TURN][mouse][catFrom] != DRAW) queue.offer(new int[]{CAT_TURN, mouse, catFrom});
                    }
                }
            } else {
                for (int mouseFrom : graph[mouse]) {
                    if (dp[MOUSE_TURN][mouseFrom][cat] == DRAW) {
                        if (result == MOUSE_WIN) dp[MOUSE_TURN][mouseFrom][cat] = MOUSE_WIN;
                        else if (--count[MOUSE_TURN][mouseFrom][cat] == 0) dp[MOUSE_TURN][mouseFrom][cat] = CAT_WIN;
                        if (dp[MOUSE_TURN][mouseFrom][cat] != DRAW) queue.offer(new int[]{MOUSE_TURN, mouseFrom, cat});
                    }
                }
            }
        }
        return dp[MOUSE_TURN][1][2];
    }
}
