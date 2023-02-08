package help_requests.line_by_line_knight;

import java.util.Arrays;

public class Solution {

    // S - start, E - end, # - obstacle, ' ' - empty cell

    // O(n^2) - space, O(m*n^3) - time
    public static int minDistance(String[] field) {
        int m = field.length, n = field[0].length();
        boolean[][] obstacle = new boolean[3][n];
        int[][] distToStart = new int[3][n];
        int[][] distToEnd = new int[3][n];
        int[][][][] distBetween = new int[3][3][n][n];

        for (int[] arr : distToStart) Arrays.fill(arr, -1);
        for (int[] arr : distToEnd) Arrays.fill(arr, -1);
        for (int[][][] arr : distBetween) for (int[][] arr2 : arr) for (int[] arr3 : arr2) Arrays.fill(arr3, -1);
        for (boolean[] arr : obstacle) Arrays.fill(arr, true);

        int minDist = -1;

        for (String s : field) {
            Arrays.fill(distToStart[2], -1);
            Arrays.fill(distToEnd[2], -1);
            Arrays.fill(obstacle[2], false);
            clearDistBetween(distBetween);

            for (int j = 0; j < n; j++) {
                char c = s.charAt(j);
                if (c == 'S') {
                    distToStart[2][j] = 0;
                } else if (c == 'E') {
                    distToEnd[2][j] = 0;
                } else if (c == '#') {
                    obstacle[2][j] = true;
                }
            }

            // add new edges
            for (int i = 0; i < n; i++) {
                if (!obstacle[0][i] && i - 1 >= 0 && !obstacle[2][i - 1]) {
                    distBetween[0][2][i][i - 1] = 1;
                    distBetween[2][0][i - 1][i] = 1;
                }
                if (!obstacle[0][i] && i + 1 < n && !obstacle[2][i + 1]) {
                    distBetween[0][2][i][i + 1] = 1;
                    distBetween[2][0][i + 1][i] = 1;
                }
                if (!obstacle[1][i] && i - 2 > 0 && !obstacle[2][i - 2]) {
                    distBetween[1][2][i][i - 2] = 1;
                    distBetween[2][1][i - 2][i] = 1;
                }
                if (!obstacle[1][i] && i + 2 < n && !obstacle[2][i + 2]) {
                    distBetween[1][2][i][i + 2] = 1;
                    distBetween[2][1][i + 2][i] = 1;
                }
            }

            //Floyd-Warshall
            for (int k = 0; k < 3 * n; k++) {
                int rowK = k / n, colK = k % n;
                if (obstacle[rowK][colK]) continue;
                for (int i = 0; i < 3 * n; i++) {
                    int rowI = i / n, colI = i % n;
                    if (obstacle[rowI][colI]) continue;
                    for (int j = 0; j < 3 * n; j++) {
                        int rowJ = j / n, colJ = j % n;
                        if (obstacle[rowJ][colJ]) continue;
                        if (distBetween[rowI][rowK][colI][colK] != -1 && distBetween[rowK][rowJ][colK][colJ] != -1) {
                            int newDist = distBetween[rowI][rowK][colI][colK] + distBetween[rowK][rowJ][colK][colJ];
                            if (distBetween[rowI][rowJ][colI][colJ] == -1 || distBetween[rowI][rowJ][colI][colJ] > newDist) {
                                distBetween[rowI][rowJ][colI][colJ] = newDist;
                                distBetween[rowJ][rowI][colJ][colI] = newDist;
                            }
                        }
                    }
                }
            }

            // update distances to start and end (Floyd-Warshall)
            for (int k = 0; k < 3 * n; k++) {
                int rowK = k / n, colK = k % n;
                if (obstacle[rowK][colK]) continue;
                for (int i = 0; i < 3 * n; i++) {
                    int rowI = i / n, colI = i % n;
                    if (obstacle[rowI][colI]) continue;
                    if (distBetween[rowI][rowK][colI][colK] != -1 && distToStart[rowK][colK] != -1) {
                        int newDist = distBetween[rowI][rowK][colI][colK] + distToStart[rowK][colK];
                        if (distToStart[rowI][colI] == -1 || distToStart[rowI][colI] > newDist) {
                            distToStart[rowI][colI] = newDist;
                        }
                    }
                    if (distBetween[rowI][rowK][colI][colK] != -1 && distToEnd[rowK][colK] != -1) {
                        int newDist = distBetween[rowI][rowK][colI][colK] + distToEnd[rowK][colK];
                        if (distToEnd[rowI][colI] == -1 || distToEnd[rowI][colI] > newDist) {
                            distToEnd[rowI][colI] = newDist;
                        }
                    }
                }
            }

            for (int i = 0; i < 3 * n; i++) {
                int rowI = i / n, colI = i % n;
                if (obstacle[rowI][colI]) continue;
                if (distToStart[rowI][colI] != -1 && distToEnd[rowI][colI] != -1) {
                    int newDist = distToStart[rowI][colI] + distToEnd[rowI][colI];
                    if (minDist == -1 || minDist > newDist) {
                        minDist = newDist;
                    }
                }
            }

            shift(distToStart);
            shift(distToEnd);
            shift(obstacle);
            shiftDistBetween(distBetween);
        }
        return minDist;
    }

    private static void shiftDistBetween(int[][][][] distBetween) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                swap(distBetween, i, j, i + 1, j + 1);
            }
        }
    }

    private static void shift(Object[] arr) {
        swap(arr, 0, 1);
        swap(arr, 1, 2);
    }

    private static void clearDistBetween(int[][][][] distBetween) {
        for (int i = 0; i < 2; i++) {
            clearArray(distBetween[i][2]);
            clearArray(distBetween[2][i]);
        }
        clearArray(distBetween[2][2]);
    }

    private static void swap(Object[][] arr, int i1, int j1, int i2, int j2) {
        Object temp = arr[i1][j1];
        arr[i1][j1] = arr[i2][j2];
        arr[i2][j2] = temp;
    }

    private static void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void clearArray(int[][] arr) {
        for (int[] a : arr) Arrays.fill(a, -1);
    }
}
