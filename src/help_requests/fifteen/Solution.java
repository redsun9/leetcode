package help_requests.fifteen;

import java.util.*;

import static java.lang.Math.abs;

//A* - algorithm

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    private static final int[] moves = {1, 0, -1, 0, 1};
    private static final boolean countDistForZero = false;

    private final int m, n, total;
    private final int[] xInitial, yInitial, xTarget, yTarget;
    private final int[][] initialBoard;
    private final boolean unsolvable;

    public Solution(int[][] board) {
        m = board.length;
        n = board[0].length;
        total = m * n;
        xInitial = new int[total];
        yInitial = new int[total];
        xTarget = new int[total];
        yTarget = new int[total];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                xInitial[board[i][j]] = i;
                yInitial[board[i][j]] = j;
            }
        }
        for (int i = 1; i < total; i++) {
            xTarget[i] = (i - 1) / n;
            yTarget[i] = (i - 1) % n;
        }
        xTarget[0] = m - 1;
        yTarget[0] = n - 1;

        initialBoard = board;
        unsolvable = isUnsolvable();
    }

    public List<Integer> solveSlidingPuzzle() {
        if (unsolvable) return null;
        Map<BoardState, Move> visited = new HashMap<>();
        PriorityQueue<BoardState> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.f));
        BoardState state = new BoardState(initialBoard, xInitial[0], yInitial[0], hForInitialState(), 0), newState;
        pq.offer(state);
        visited.put(state, new Move(state, -1));
        int[][] board;
        int zx, zy, heuristic, distance, newZx, newZy, newHeuristic, newDistance, tile;
        while (!pq.isEmpty()) {
            state = pq.poll();
            heuristic = state.h;
            distance = state.g;
            if (heuristic == 0) break;
            zx = state.zx;
            zy = state.zy;
            board = state.board;
            for (int k = 0; k < 4; k++) {
                newZx = zx + moves[k];
                newZy = zy + moves[k + 1];
                if (newZx < 0 || newZx >= m || newZy < 0 || newZy >= n) continue;
                tile = board[newZx][newZy];
                newHeuristic = heuristic + updateHeuristic(zx, zy, newZx, newZy, tile, xTarget, yTarget);
                newDistance = distance + updateHeuristic(zx, zy, newZx, newZy, tile, xInitial, yInitial);

                int[][] newBoard = board.clone();
                newBoard[zx] = board[zx].clone();
                if (zx != newZx) newBoard[newZx] = board[newZx].clone();
                newBoard[newZx][newZy] = 0;
                newBoard[zx][zy] = tile;
                newState = new BoardState(newBoard, newZx, newZy, newHeuristic, newDistance);
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


    private int updateHeuristic(int zx, int zy, int newZx, int newZy, int tile, int[] x, int[] y) {
        int ans = countDistForZero ? abs(x[0] - newZx) + abs(y[0] - newZy) - abs(x[0] - zx) - abs(y[0] - zy) : 0;
        return ans - abs(x[tile] - newZx) - abs(y[tile] - newZy) + abs(x[tile] - zx) + abs(y[tile] - zy);
    }

    boolean isUnsolvable() {
        return calculateInvariant(xInitial, yInitial) != calculateInvariant(xTarget, yTarget);
    }

    private boolean calculateInvariant(int[] x, int[] y) {
        int s = 0;
        for (int i = 0; i < total; i++) {
            for (int j = i + 1; j < total; j++) {
                if (x[i] > x[j] || x[i] == x[j] && y[i] > y[j]) s++;
            }
        }
        s += x[0] + y[0];
        return s % 2 == 0;
    }

    private int hForInitialState() {
        int heuristic = 0;
        for (int i = countDistForZero ? 0 : 1; i < total; i++) {
            heuristic += abs(xTarget[i] - xInitial[i]) + abs(yTarget[i] - yInitial[i]);
        }
        return heuristic;
    }

    private static final class BoardState {
        private final int[][] board;
        private final int zx, zy, h, g, f;

        private BoardState(int[][] board, int zx, int zy, int h, int g) {
            this.board = board;
            this.zx = zx;
            this.zy = zy;
            this.h = h;
            this.g = g;
            this.f = g + h;
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
}
