package help_requests.fifteen;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import stress.StressTester;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
    @Test
    @Disabled
    void testSolvable() throws InterruptedException {
        for (int m = 2; m < 10; m++) {
            int finalM = m;
            for (int n = m; n < 10; n++) {
                int finalN = n;
                assertTrue(StressTester.exactStressTest(
                        seed -> this.generateTestCase(seed, finalM, finalN),
                        Solution2::isUnsolvable,
                        board -> new Solution(board).isUnsolvable(),
                        1_000,
                        1,
                        0
                ));
            }
        }
    }

    @Test
    @Disabled
    void testFirstSolution() throws InterruptedException {
        assertTrue(StressTester.constructionStressTest(
                seed -> generateTestCase(seed, 3, 3),
                board -> new Solution(board).solveSlidingPuzzle(),
                this::validateSolution,
                1000,
                1,
                100
        ));
    }

    @Test
    @Disabled
    void testSecondSolution() throws InterruptedException {
        assertTrue(StressTester.constructionStressTest(
                seed -> generateTestCase(seed, 5, 5),
                Solution2::solveSlidingPuzzle,
                this::validateSolution,
                1000,
                1,
                100
        ));
    }

    @Test
    @Disabled
    void testThirdSolution() throws InterruptedException {
        assertTrue(StressTester.constructionStressTest(
                seed -> generateTestCase(seed, 3, 3),
                Solution3::solveSlidingPuzzle,
                this::validateSolution,
                1000,
                1,
                100
        ));
    }

    private int[][] generateTestCase(long seed, int m, int n) {
        int[][] board = new int[m][n];
        for (int i = 0, val = 0; i < m; i++) for (int j = 0; j < n; j++) board[i][j] = val++;
        int total = m * n;
        Random rand = new Random(seed);
        for (int idx1 = total - 1; idx1 >= 1; idx1--) {
            int idx2 = rand.nextInt(idx1 + 1);
            int tmp = board[idx1 / n][idx1 % n];
            board[idx1 / n][idx1 % n] = board[idx2 / n][idx2 % n];
            board[idx2 / n][idx2 % n] = tmp;
        }
        return board;
    }

    private boolean validateSolution(int[][] board, List<Integer> moves) {
        if (moves == null) return Solution2.isUnsolvable(board);
        int m = board.length, n = board[0].length;
        int totalCells = m * n;
        int[] x = new int[totalCells], y = new int[totalCells];
        int zx = 0, zy = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                x[board[i][j]] = i;
                y[board[i][j]] = j;
                if (board[i][j] == 0) {
                    zx = i;
                    zy = j;
                }
            }
        }
        for (Integer move : moves) {
            int newZx = x[move], newZy = y[move];
            if (Math.abs(newZx - zx) + Math.abs(newZy - zy) != 1) return false;
            x[move] = zx;
            y[move] = zy;
            zx = newZx;
            zy = newZy;
        }

        for (int i = 1; i < totalCells; i++) {
            if (x[i] != (i - 1) / n || y[i] != (i - 1) % n) return false;
        }
        return true;
    }
}