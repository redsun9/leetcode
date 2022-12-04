package help_requests.gomoku_draw;

import org.junit.jupiter.api.Test;
import stress.StressTester;

import java.util.Comparator;
import java.util.Random;
import java.util.stream.Collectors;

import static java.util.stream.IntStream.range;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
    private static final int minNForBoard = 5, maxNForBoard = 10, kForBoard = 4;

    @Test
    void testBoard1() {
        int[][] board = SolutionTest.generateBoard(8675619457076107145L);
        boolean[] expected = canWinBoardDummy(board, kForBoard);
        boolean[] actual = Solution.canWinBoard(board, kForBoard);
        assertArrayEquals(expected, actual);
    }

    @Test
    void canWinBoardRandom() throws InterruptedException {
        StressTester.exactStressTest(
                SolutionTest::generateBoard,
                board -> canWinBoardDummy(board, kForBoard),
                board -> Solution.canWinBoard(board, kForBoard),
                1_000_000,
                1,
                100_000
        );
    }

    @Test
    void testCanWinRow1() {
        int[] row = {2, 1, 0, 1};
        int k = 3;
        boolean[] expected = {true, false};
        boolean[] actual = Solution.canWinRow(row, k);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testCanWinRow2() {
        int[] row = {0, 0, 2, 1};
        int k = 3;
        boolean[] expected = {false, true};
        boolean[] actual = Solution.canWinRow(row, k);
        assertArrayEquals(expected, actual);
    }

    @Test
    void canWinRowRandom() throws InterruptedException {
        final int n = 1000, k = 4;
        StressTester.exactStressTest(
                seed -> {
                    Random random = new Random(seed);
                    int[] row = new int[n];
                    for (int i = 0; i < n; i++) row[i] = random.nextInt(3);
                    return row;
                },
                row -> canWinRowDummy(row, k),
                row -> Solution.canWinRow(row, k),
                1_000_000,
                1,
                100_000
        );
    }

    private static int[][] generateBoard(long seed) {
        Random random = new Random(seed);
        int m = minNForBoard + random.nextInt(maxNForBoard - minNForBoard + 1);
        int n = minNForBoard + random.nextInt(maxNForBoard - minNForBoard + 1);
        int[][] board = new int[m][n];
        for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) board[i][j] = random.nextInt(3);
        return board;
    }

    private static boolean[] canWinRowDummy(int[] row, int k) {
        int n = row.length;
        boolean[] ans = {false, false};
        if (n < k) return ans;
        for (int l = -1, r = k; !ans[0] && r <= n; l++, r++) {
            boolean curr = (l < 0 || row[l] != 1) && (r >= n || row[r] != 1);
            for (int i = l + 1; curr && i < r; i++) curr = row[i] != 2;
            ans[0] = curr;
        }
        for (int l = -1, r = k; !ans[1] && r <= n; l++, r++) {
            boolean curr = (l < 0 || row[l] != 2) && (r >= n || row[r] != 2);
            for (int i = l + 1; curr && i < r; i++) curr = row[i] != 1;
            ans[1] = curr;
        }
        return ans;
    }

    private static boolean[] canWinBoardDummy(int[][] a, int k) {
        int m = a.length, n = a[0].length;
        boolean[] canWinByRow = range(0, m).boxed().flatMap(i -> range(0, n).mapToObj(j -> new int[]{i, j, a[i][j]}))
                .collect(Collectors.groupingBy(arr -> arr[0])).values().stream()
                .map(list -> list.stream().sorted(Comparator.comparingInt(x -> x[1])).mapToInt(x -> x[2]).toArray())
                .map(arr -> canWinRowDummy(arr, k))
                .reduce(new boolean[]{false, false}, (x, y) -> new boolean[]{x[0] | y[0], x[1] | y[1]});

        boolean[] canWinByColumn = range(0, m).boxed().flatMap(i -> range(0, n).mapToObj(j -> new int[]{i, j, a[i][j]}))
                .collect(Collectors.groupingBy(arr -> arr[1])).values().stream()
                .map(list -> list.stream().sorted(Comparator.comparingInt(x -> x[0])).mapToInt(x -> x[2]).toArray())
                .map(arr -> canWinRowDummy(arr, k))
                .reduce(new boolean[]{false, false}, (x, y) -> new boolean[]{x[0] | y[0], x[1] | y[1]});

        boolean[] canWinByDiag1 = range(0, m).boxed().flatMap(i -> range(0, n).mapToObj(j -> new int[]{i, j, a[i][j]}))
                .collect(Collectors.groupingBy(arr -> arr[0] - arr[1])).values().stream()
                .map(list -> list.stream().sorted(Comparator.comparingInt(x -> x[0])).mapToInt(x -> x[2]).toArray())
                .map(arr -> canWinRowDummy(arr, k))
                .reduce(new boolean[]{false, false}, (x, y) -> new boolean[]{x[0] | y[0], x[1] | y[1]});

        boolean[] canWinByDiag2 = range(0, m).boxed().flatMap(i -> range(0, n).mapToObj(j -> new int[]{i, j, a[i][j]}))
                .collect(Collectors.groupingBy(arr -> arr[0] + arr[1])).values().stream()
                .map(list -> list.stream().sorted(Comparator.comparingInt(x -> x[0])).mapToInt(x -> x[2]).toArray())
                .map(arr -> canWinRowDummy(arr, k))
                .reduce(new boolean[]{false, false}, (x, y) -> new boolean[]{x[0] | y[0], x[1] | y[1]});

        return new boolean[]{
                canWinByRow[0] | canWinByColumn[0] | canWinByDiag1[0] | canWinByDiag2[0],
                canWinByRow[1] | canWinByColumn[1] | canWinByDiag1[1] | canWinByDiag2[1]
        };
    }
}