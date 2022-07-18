package help_requests.fifteen;

import java.util.*;

//Best-first search algorithm

@SuppressWarnings("DuplicatedCode")
public class Solution2 {
    private static final int[] moves = {1, 0, -1, 0, 1};
    private static final boolean countDistForZero = false;

    public static List<Integer> solveSlidingPuzzle(int[][] board) {
        if (isUnsolvable(board)) return null;
        int m = board.length, n = board[0].length;
        Map<BoardState, Move> visited = new HashMap<>();
        PriorityQueue<BoardState> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.heuristic));
        BoardState state = BoardState.create(board), newState;
        pq.offer(state);
        visited.put(state, new Move(state, -1));
        int zx, zy, heuristic, newZx, newZy, newHeuristic, tile;
        while (!pq.isEmpty()) {
            state = pq.poll();
            heuristic = state.heuristic;
            if (heuristic == 0) break;
            zx = state.zx;
            zy = state.zy;
            board = state.board;
            for (int k = 0; k < 4; k++) {
                newZx = zx + moves[k];
                newZy = zy + moves[k + 1];
                if (newZx < 0 || newZx >= m || newZy < 0 || newZy >= n) continue;
                tile = board[newZx][newZy];
                newHeuristic = heuristic;
                if (countDistForZero) newHeuristic += zx + zy - newZx - newZy;
                newHeuristic -= Math.abs((tile - 1) / n - newZx) + Math.abs((tile - 1) % n - newZy);
                newHeuristic += Math.abs((tile - 1) / n - zx) + Math.abs((tile - 1) % n - zy);

                int[][] newBoard = board.clone();
                newBoard[zx] = board[zx].clone();
                if (zx != newZx) newBoard[newZx] = board[newZx].clone();
                newBoard[newZx][newZy] = 0;
                newBoard[zx][zy] = tile;
                newState = new BoardState(newBoard, newZx, newZy, newHeuristic);
                if (visited.putIfAbsent(newState, new Move(state, tile)) == null) pq.offer(newState);
            }
        }
        LinkedList<Integer> ans = new LinkedList<>();
        while (true) {
            Move move = visited.get(state);
            if (move.tile == -1) break;
            ans.addFirst(move.tile);
            state = move.from;
        }
        return ans;
    }

    static boolean isUnsolvable(int[][] board) {
        int s = 0, m = board.length, n = board[0].length, total = m * n;
        for (int idx1 = 0; idx1 < total; idx1++) {
            int val1 = board[idx1 / n][idx1 % n] - 1;
            if (val1 == -1) {
                val1 = total - 1;
                s += (m - 1 - idx1 / n) + (n - 1 - idx1 % n);
            }
            for (int idx2 = idx1 + 1; idx2 < total; idx2++) {
                int val2 = board[idx2 / n][idx2 % n] - 1;
                if (val2 == -1) val2 = total - 1;
                if (val1 > val2) s++;
            }
        }
        return s % 2 != 0;
    }


    @SuppressWarnings({"SpellCheckingInspection", "ConstantConditions"})
    private record BoardState(int[][] board, int zx, int zy, int heuristic) {
        public static BoardState create(int[][] board) {
            int[] zxzy = getZxZy(board);
            int heuristic = calculateHeuristic(board);
            return new BoardState(board, zxzy[0], zxzy[1], heuristic);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            BoardState that = (BoardState) o;
            return zx == that.zx && zy == that.zy && Arrays.deepEquals(board, that.board);
        }

        @Override
        public int hashCode() {
            return Objects.hash(zx, zy, Arrays.deepHashCode(board));
        }
    }

    private record Move(BoardState from, int tile) {
    }

    static int calculateHeuristic(int[][] board) {
        int m = board.length, n = board[0].length, heuristic = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = board[i][j];
                if (num == 0) {
                    if (countDistForZero) heuristic += (m - 1 - i) + (n - 1 - j);
                } else {
                    heuristic += Math.abs((num - 1) / n - i) + Math.abs((num - 1) % n - j);
                }
            }
        }
        return heuristic;
    }

    static int[] getZxZy(int[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) if (board[i][j] == 0) return new int[]{i, j};
        return null;
    }
}
