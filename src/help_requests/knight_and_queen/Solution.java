package help_requests.knight_and_queen;

import java.util.Arrays;

@SuppressWarnings("ConstantValue")
public class Solution {
    private static final int n = 8, total = n * n;
    private static final int queenX = 3, queenY = 4;

    private static final int[][] moves = {{1, 2}, {2, 1}, {-1, 2}, {2, -1}, {-2, 1}, {1, -2}, {-1, -2}, {-2, -1}};

    public static void main(String[] args) {
        int[][] dist = new int[total][total];
        boolean[] forbidden = new boolean[total];
        forbidden[queenX * n + queenY] = true;
        int sumOfQueenXY = queenX + queenY;
        int difOfQueenXY = queenY - queenX;
        for (int i = 0; i < n; i++) {
            forbidden[i * n + queenY] = true;
            forbidden[queenX * n + i] = true;
            int d1Y = sumOfQueenXY - i;
            if (d1Y >= 0 && d1Y < n) forbidden[i * n + d1Y] = true;
            int d2Y = difOfQueenXY + i;
            if (d2Y >= 0 && d2Y < n) forbidden[i * n + d2Y] = true;
        }

        for (int[] arr : dist) Arrays.fill(arr, n * n);
        for (int i = 0; i < total; i++) {
            if (forbidden[i]) continue;
            dist[i][i] = 0;
        }

        for (int from = 0; from < total; from++) {
            if (forbidden[from]) continue;
            int x = from / n, y = from % n;
            for (int[] move : moves) {
                int newI = x + move[0], newJ = y + move[1], to = newI * n + newJ;
                if (newI >= 0 && newI < n && newJ >= 0 && newJ < n && !forbidden[to]) dist[from][to] = 1;
            }
        }

        for (int k = 0; k < total; k++) {
            if (forbidden[k]) continue;
            for (int i = 0; i < total; i++) {
                if (forbidden[i]) continue;
                for (int j = 0; j < total; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int maxDist = 0;
        int maxFrom = 0, maxTo = 0;
        for (int from = 0; from < total; from++) {
            if (forbidden[from]) continue;
            for (int to = from; to < total; to++) {
                if (forbidden[to]) continue;
                if (maxDist < dist[from][to]) {
                    maxDist = dist[from][to];
                    maxFrom = from;
                    maxTo = to;
                }
            }
        }
        System.out.println(maxDist);
        System.out.println(maxFrom);
        System.out.println(maxTo);
    }
}
