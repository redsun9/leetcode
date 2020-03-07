package codeforces.contest1320;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class ProblemFTest {
    @Test
    void testSolve() {
        int n = 4;
        int m = 3;
        int k = 2;
        int[][] bottom = {
                {1, 4},
                {3, 2},
                {6, 5}
        };
        int[][] top = {
                {1, 4},
                {3, 2},
                {6, 7},
        };
        int[][] left = {
                {1, 4},
                {1, 4},
                {0, 0},
                {0, 7}
        };
        int[][] right = {
                {6, 5},
                {6, 5},
                {0, 0},
                {0, 7}
        };

        int[][] front = {
                {1, 3, 6},
                {1, 3, 6},
                {0, 0, 0},
                {0, 0, 7}
        };

        int[][] back = {
                {4, 3, 5},
                {4, 2, 5},
                {0, 0, 0},
                {0, 0, 7}
        };
        ProblemF problemF = new ProblemF(n, m, k, bottom, top, left, right, front, back);
        assertNotNull(problemF.solve());
    }

    @Test
    void testMassive() {
        Random random = new Random();
        IntStream.range(0, 100).parallel().forEach(test -> {
            int n = 3 + random.nextInt(100);
            int m = 3 + random.nextInt(200);
            int k = 3 + random.nextInt(300);
            int c = 1 + random.nextInt(20);
            int[][][] field = new int[n][m][k];
            int p = n * m * k;
            for (int j = 0; j < p; j++) {
                field[random.nextInt(n)][random.nextInt(m)][random.nextInt(k)] = 1 + random.nextInt(c);
            }
            //fill bottom
            int[][] bottom = new int[m][k];
            for (int j = 0; j < m; j++) {
                for (int l = 0; l < k; l++) {
                    int i = 0;
                    while (i < n && bottom[j][l] == 0) {
                        bottom[j][l] = field[i][j][l];
                        i++;
                    }
                }
            }
            //fill top
            int[][] top = new int[m][k];
            for (int j = 0; j < m; j++) {
                for (int l = 0; l < k; l++) {
                    int i = n - 1;
                    while (i >= 0 && top[j][l] == 0) {
                        top[j][l] = field[i][j][l];
                        i--;
                    }
                }
            }

            //fill left
            int[][] left = new int[n][k];
            for (int i = 0; i < n; i++) {
                for (int l = 0; l < k; l++) {
                    int j = 0;
                    while (j < m && left[i][l] == 0) {
                        left[i][l] = field[i][j][l];
                        j++;
                    }
                }
            }
            //fill right
            int[][] right = new int[n][k];
            for (int i = 0; i < n; i++) {
                for (int l = 0; l < k; l++) {
                    int j = m - 1;
                    while (j >= 0 && right[i][l] == 0) {
                        right[i][l] = field[i][j][l];
                        j--;
                    }
                }
            }
            //fill front
            int[][] front = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int l = 0;
                    while (l < k && front[i][j] == 0) {
                        front[i][j] = field[i][j][l];
                        l++;
                    }
                }
            }
            //fill back
            int[][] back = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int l = k - 1;
                    while (l >= 0 && back[i][j] == 0) {
                        back[i][j] = field[i][j][l];
                        l--;
                    }
                }
            }
            ProblemF problemF = new ProblemF(n, m, k, bottom, top, left, right, front, back);
            int[][][] solution = problemF.solve();
            assertNotNull(solution);
            checkSolution(solution, bottom, top, left, right, front, back);
        });
    }

    private static void checkSolution(int[][][] solution, int[][] bottom, int[][] top, int[][] left, int[][] right, int[][] front, int[][] back) {
        int n = solution.length;
        int m = solution[0].length;
        int k = solution[0][0].length;
        for (int j = 0; j < m; j++) {
            for (int l = 0; l < k; l++) {
                int bottomColor = bottom[j][l];
                if (bottomColor == 0) {
                    for (int i = 0; i < n; i++) {
                        assertEquals(0, solution[i][j][l]);
                    }
                } else {
                    boolean found = false;
                    for (int i = 0; i < n; i++) {
                        found = solution[i][j][l] == bottomColor;
                        assertTrue(found || solution[i][j][l] == 0);
                        if (found) break;
                    }
                    assertTrue(found);
                }
            }
        }
        for (int j = 0; j < m; j++) {
            for (int l = 0; l < k; l++) {
                int topColor = top[j][l];
                if (topColor == 0) {
                    for (int i = 0; i < n; i++) {
                        assertEquals(0, solution[i][j][l]);
                    }
                } else {
                    boolean found = false;
                    for (int i = n - 1; i >= 0; i--) {
                        found = solution[i][j][l] == topColor;
                        assertTrue(found || solution[i][j][l] == 0);
                        if (found) break;
                    }
                    assertTrue(found);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int l = 0; l < k; l++) {
                int leftColor = left[i][l];
                if (leftColor == 0) {
                    for (int j = 0; j < m; j++) {
                        assertEquals(0, solution[i][j][l]);
                    }
                } else {
                    boolean found = false;
                    for (int j = 0; j < m; j++) {
                        found = solution[i][j][l] == leftColor;
                        assertTrue(found || solution[i][j][l] == 0);
                        if (found) break;
                    }
                    assertTrue(found);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int l = 0; l < k; l++) {
                int rightColor = right[i][l];
                if (rightColor == 0) {
                    for (int j = 0; j < m; j++) {
                        assertEquals(0, solution[i][j][l]);
                    }
                } else {
                    boolean found = false;
                    for (int j = m - 1; j >= 0; j--) {
                        found = solution[i][j][l] == rightColor;
                        assertTrue(found || solution[i][j][l] == 0);
                        if (found) break;
                    }
                    assertTrue(found);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int frontColor = front[i][j];
                if (frontColor == 0) {
                    for (int l = 0; l < k; l++) {
                        assertEquals(0, solution[i][j][l]);
                    }
                } else {
                    boolean found = false;
                    for (int l = 0; l < m; l++) {
                        found = solution[i][j][l] == frontColor;
                        assertTrue(found || solution[i][j][l] == 0);
                        if (found) break;
                    }
                    assertTrue(found);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int backColor = back[i][j];
                if (backColor == 0) {
                    for (int l = 0; l < k; l++) {
                        assertEquals(0, solution[i][l][l]);
                    }
                } else {
                    boolean found = false;
                    for (int l = k - 1; l >= 0; l--) {
                        found = solution[i][j][l] == backColor;
                        assertTrue(found || solution[i][j][l] == 0);
                        if (found) break;
                    }
                    assertTrue(found);
                }
            }
        }
    }
}