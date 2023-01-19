package puzzles.anima;

import java.util.*;

public class Solution {
    private static final int MAX_DEPTH = 100;

    public static Direction[] solve(int[][] field, int[][] redStartCoords, int[][] redEndCoords, int[][] blueStartCoords, int[][] blueEndCoords) {
        int m = field.length, n = field[0].length, totalCells = 0;
        int[][] mapping = new int[m][n];
        for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) if (field[i][j] == 1) mapping[i][j] = totalCells++;

        int[][] cellCoordinates = new int[totalCells][2];
        for (int i = 0, pos = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (field[i][j] == 1) {
                    cellCoordinates[pos][0] = i;
                    cellCoordinates[pos][1] = j;
                    pos++;
                }
            }
        }

        int redCount = redStartCoords.length;
        int[] redStart = new int[redCount];
        for (int i = 0; i < redCount; i++) redStart[i] = mapping[redStartCoords[i][0]][redStartCoords[i][1]];

        int redTargetCount = redEndCoords.length;
        int[] redEnd = new int[redTargetCount];
        for (int i = 0; i < redTargetCount; i++) redEnd[i] = mapping[redEndCoords[i][0]][redEndCoords[i][1]];

        int blueCount = blueStartCoords.length;
        int[] blueStart = new int[blueCount];
        for (int i = 0; i < blueCount; i++) blueStart[i] = mapping[blueStartCoords[i][0]][blueStartCoords[i][1]];

        int blueTargetCount = blueEndCoords.length;
        int[] blueEnd = new int[blueTargetCount];
        for (int i = 0; i < blueTargetCount; i++) blueEnd[i] = mapping[blueEndCoords[i][0]][blueEndCoords[i][1]];

        State startState = new State(redStart, blueStart);
        State endState = new State(redEnd, blueEnd);

        Map<State, Edge> visited = new HashMap<>();
        visited.put(startState, new Edge(null, null));

        Queue<State> prevQueue = new ArrayDeque<>(), nextQueue = new ArrayDeque<>(), tmp = null;
        prevQueue.offer(startState);

        boolean found = false;
        int ansLength = 1;
        while (!found && ansLength <= MAX_DEPTH) {
            while (!found && !prevQueue.isEmpty()) {
                State prevState = prevQueue.poll();
                for (Direction direction : Direction.values()) {
                    State newState = makeMove(prevState, direction, field, mapping, cellCoordinates, m, n, redCount, blueCount);
                    if (!visited.containsKey(newState)) {
                        visited.put(newState, new Edge(prevState, direction));
                        nextQueue.offer(newState);
                    }
                    if (meetRequirements(newState, endState)) {
                        found = true;
                        endState = newState;
                        break;
                    }
                }
            }
            if (!found) {
                tmp = prevQueue;
                prevQueue = nextQueue;
                nextQueue = tmp;
                ansLength++;
            }
        }

        if (!found) return null;

        Direction[] ans = new Direction[ansLength];
        for (int i = ansLength - 1; i >= 0; i--) {
            Edge edge = visited.get(endState);
            ans[i] = edge.direction;
            endState = edge.prevState;
        }
        return ans;
    }

    private static State makeMove(State state, Direction direction, int[][] field, int[][] mapping, int[][] cellCoordinates, int m, int n, int redCount, int blueCount) {
        boolean[][] red = new boolean[m][n], blue = new boolean[m][n];
        for (int idx : state.red) red[cellCoordinates[idx][0]][cellCoordinates[idx][1]] = true;
        for (int idx : state.blue) blue[cellCoordinates[idx][0]][cellCoordinates[idx][1]] = true;

        boolean redMovingForward = direction.di > 0 || direction.dj > 0;
        int absDi = Math.abs(direction.di), absDj = Math.abs(direction.dj);
        boolean[][] forward = redMovingForward ? red : blue;
        boolean[][] backward = redMovingForward ? blue : red;

        boolean[][] blocked = new boolean[m][n];
        for (int k = 0; k < 2; k++) {
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    if (!forward[i][j]) continue;
                    int newI = i + absDi, newJ = j + absDj;
                    int blockI = newI + absDi, blockJ = newJ + absDj;
                    blocked[i][j] |= newI >= m || newJ >= n || field[newI][newJ] != 1 || blocked[newI][newJ] || blockI < m && blockJ < n && backward[blockI][blockJ];
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (!backward[i][j]) continue;
                    int newI = i - absDi, newJ = j - absDj;
                    int blockI = newI - absDi, blockJ = newJ - absDj;
                    blocked[i][j] |= newI < 0 || newJ < 0 || field[newI][newJ] != 1 || blocked[newI][newJ] || blockI >= 0 && blockJ >= 0 && forward[blockI][blockJ];
                }
            }
        }

        boolean[][] newRed = new boolean[m][n], newBlue = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (red[i][j]) {
                    if (blocked[i][j]) newRed[i][j] = true;
                    else newRed[i + direction.di][j + direction.dj] = true;
                } else if (blue[i][j]) {
                    if (blocked[i][j]) newBlue[i][j] = true;
                    else newBlue[i - direction.di][j - direction.dj] = true;
                }
            }
        }

        return new State(getIndexes(newRed, mapping, m, n, redCount), getIndexes(newBlue, mapping, m, n, blueCount));
    }

    private static int[] getIndexes(boolean[][] arr, int[][] mapping, int m, int n, int k) {
        int[] ans = new int[k];
        for (int i = 0, pos = 0; i < m; i++) for (int j = 0; j < n; j++) if (arr[i][j]) ans[pos++] = mapping[i][j];
        return ans;
    }

    private static boolean meetRequirements(State state, State target) {
        return overlap(state.red, target.red) && overlap(state.blue, target.blue);
    }

    private static boolean overlap(int[] a, int[] b) {
        int m = a.length, n = b.length, i = 0, j = 0;
        while (i < m && j < n) {
            if (a[i] == b[j]) j++;
            else if (a[i] > b[j]) return false;
            i++;
        }
        return j == n;
    }

    private record State(int[] red, int[] blue) {
        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null || obj.getClass() != this.getClass()) return false;
            var that = (State) obj;
            return Arrays.equals(this.red, that.red) && Arrays.equals(this.blue, that.blue);
        }

        @Override
        public int hashCode() {
            return Objects.hash(Arrays.hashCode(red), Arrays.hashCode(blue));
        }

        @Override
        public String toString() {
            return "State[" + "red=" + Arrays.toString(red) + ", " + "blue=" + Arrays.toString(blue) + ']';
        }
    }

    public enum Direction {
        UP(-1, 0),
        DOWN(1, 0),
        LEFT(0, -1),
        RIGHT(0, 1);
        private final int di, dj;

        Direction(int di, int dj) {
            this.di = di;
            this.dj = dj;
        }
    }

    private record Edge(State prevState, Direction direction) {
    }
}
