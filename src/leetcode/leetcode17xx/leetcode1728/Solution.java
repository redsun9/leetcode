package leetcode.leetcode17xx.leetcode1728;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@SuppressWarnings("unchecked")
public class Solution {
    public static final int[] directions = {1, 0, -1, 0, 1};
    private final int MOUSE_TURN = 0;
    private final int CAT_TURN = 1;
    private final Integer DRAW = 0;
    private final Integer MOUSE_WIN = 1;
    private final Integer CAT_WIN = 2;

    public boolean canMouseWin(String[] grid, int catJump, int mouseJump) {
        int m = grid.length;
        int n = grid[0].length();
        int catPos = 0, mousePos = 0, foodPos = 0;
        int[][] indices = new int[m][n];
        int totalCells = 0;
        for (int i = 0; i < m; i++) {
            String s = grid[i];
            for (int j = 0; j < n; j++) {
                char c = s.charAt(j);
                if (c == '#') continue;
                indices[i][j] = ++totalCells;
                switch (c) {
                    case 'C' -> catPos = totalCells - 1;
                    case 'M' -> mousePos = totalCells - 1;
                    case 'F' -> foodPos = totalCells - 1;
                    default -> {
                    }
                }
            }
        }
        List<Integer>[] catGraph = new List[totalCells];
        List<Integer>[] mouseGraph = new List[totalCells];
        for (int i = 0; i < totalCells; i++) {
            catGraph[i] = new ArrayList<>();
            mouseGraph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int fromIndex = indices[i][j];
                if (fromIndex == 0) continue;
                fromIndex--;
                mouseGraph[fromIndex].add(fromIndex);
                catGraph[fromIndex].add(fromIndex);
                for (int k = 0; k < 4; k++) {
                    int dx = directions[k], dy = directions[k + 1];
                    int toX = i + dx, toY = j + dy, diff = 1;
                    while (diff <= catJump && toX >= 0 && toX < m && toY >= 0 && toY < n && indices[toX][toY] != 0) {
                        catGraph[fromIndex].add(indices[toX][toY] - 1);
                        diff++;
                        toX += dx;
                        toY += dy;
                    }
                    toX = i + dx;
                    toY = j + dy;
                    diff = 1;
                    while (diff <= mouseJump && toX >= 0 && toX < m && toY >= 0 && toY < n && indices[toX][toY] != 0) {
                        mouseGraph[fromIndex].add(indices[toX][toY] - 1);
                        diff++;
                        toX += dx;
                        toY += dy;
                    }
                }
            }
        }

        //(order,mouse,cat)->(0,1,2)
        int[][][] dp = new int[2][totalCells][totalCells];
        //(order,mouse,cat)
        int[][][] indegree = new int[2][totalCells][totalCells];

        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < totalCells; i++) {
            if (i == foodPos) continue;
            dp[MOUSE_TURN][i][i] = CAT_WIN;
            dp[CAT_TURN][i][i] = CAT_WIN;
            dp[MOUSE_TURN][foodPos][i] = MOUSE_WIN;
            dp[CAT_TURN][foodPos][i] = MOUSE_WIN;
            dp[MOUSE_TURN][i][foodPos] = CAT_WIN;
            dp[CAT_TURN][i][foodPos] = CAT_WIN;
            queue.offer(new int[]{MOUSE_TURN, i, i});
            queue.offer(new int[]{CAT_TURN, i, i});
            queue.offer(new int[]{MOUSE_TURN, foodPos, i});
            queue.offer(new int[]{CAT_TURN, foodPos, i});
            queue.offer(new int[]{MOUSE_TURN, i, foodPos});
            queue.offer(new int[]{CAT_TURN, i, foodPos});
        }
        for (int i = 0; i < totalCells; i++) {
            for (int j = 0; j < totalCells; j++) {
                indegree[MOUSE_TURN][i][j] = mouseGraph[i].size();
                indegree[CAT_TURN][i][j] = catGraph[j].size();
            }
        }

        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            int turn = position[0];
            int mouse = position[1];
            int cat = position[2];
            int result = dp[turn][mouse][cat];
            if (turn == MOUSE_TURN) {
                for (int catFrom : catGraph[cat]) {
                    if (dp[CAT_TURN][mouse][catFrom] == DRAW) {
                        if (result == CAT_WIN) dp[CAT_TURN][mouse][catFrom] = CAT_WIN;
                        else if (--indegree[CAT_TURN][mouse][catFrom] == 0) dp[CAT_TURN][mouse][catFrom] = MOUSE_WIN;
                        if (dp[CAT_TURN][mouse][catFrom] != DRAW) queue.offer(new int[]{CAT_TURN, mouse, catFrom});
                    }
                }
            } else {
                for (int mouseFrom : mouseGraph[mouse]) {
                    if (dp[MOUSE_TURN][mouseFrom][cat] == DRAW) {
                        if (result == MOUSE_WIN) dp[MOUSE_TURN][mouseFrom][cat] = MOUSE_WIN;
                        else if (--indegree[MOUSE_TURN][mouseFrom][cat] == 0) dp[MOUSE_TURN][mouseFrom][cat] = CAT_WIN;
                        if (dp[MOUSE_TURN][mouseFrom][cat] != DRAW) queue.offer(new int[]{MOUSE_TURN, mouseFrom, cat});
                    }
                }
            }
        }
        return dp[MOUSE_TURN][mousePos][catPos] == MOUSE_WIN;
    }
}
