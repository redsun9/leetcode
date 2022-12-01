package advent.year2021.day23.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;


@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    private static final int[] finalPosition = {0, 4, 8, 12, 1, 5, 9, 13, 2, 6, 10, 14, 3, 7, 11, 15};
    private static final int totalPlaces = 23;
    private static final int[] stepCost = {1, 10, 100, 1000};
    private static final int[][] edges = {
            {0, 4, 1}, {1, 5, 1}, {2, 6, 1}, {3, 7, 1},
            {4, 8, 1}, {5, 9, 1}, {6, 10, 1}, {7, 11, 1},
            {8, 12, 1}, {9, 13, 1}, {10, 14, 1}, {11, 15, 1},

            {16, 17, 1},
            {17, 0, 2}, {0, 18, 2}, {17, 18, 2},
            {18, 1, 2}, {1, 19, 2}, {18, 19, 2},
            {19, 2, 2}, {2, 20, 2}, {19, 20, 2},
            {20, 3, 2}, {3, 21, 2}, {20, 21, 2},
            {21, 22, 1}
    };

    private static final int[][] dist = new int[totalPlaces][totalPlaces];
    private static final int[][] path = new int[totalPlaces][totalPlaces];


    public static void main(String[] args) throws IOException {
        prepare();
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2021/day23/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2021/day23/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            scanner.nextLine();
            scanner.nextLine();

//              #D#C#B#A#
//              #D#B#A#C#


            int[] startingPositions = new int[16];
            Arrays.fill(startingPositions, -1);
            startingPositions[0] = 7;
            startingPositions[1] = 10;

            startingPositions[4] = 6;
            startingPositions[5] = 9;

            startingPositions[8] = 5;
            startingPositions[9] = 11;

            startingPositions[12] = 4;
            startingPositions[13] = 8;


            for (int i = 0; i < 2; i++) {
                String s = scanner.nextLine();
                for (int j = 0; j < 4; j++) {
                    int pos = i * 12 + j;
                    int c = s.charAt(3 + j * 2) - 'A';
                    if (startingPositions[c * 4 + 2] == -1) startingPositions[c * 4 + 2] = pos;
                    else startingPositions[c * 4 + 3] = pos;
                }
            }

            for (int i = 0; i < 4; i++) Arrays.sort(startingPositions, i * 4, (i + 1) * 4);

            State startingState = new State(null, 0, startingPositions, 0);
            HashMap<State, Integer> costMap = new HashMap<>();
            costMap.put(startingState, 0);
            PriorityQueue<QueueElement> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.cost));
            pq.offer(new QueueElement(startingState, 0));

            int ans = Integer.MAX_VALUE;
            State minPath = null;
            while (!pq.isEmpty()) {
                QueueElement poll = pq.poll();
                State state = poll.state;
                int cost = poll.cost;

                if (costMap.get(state) != cost) continue;
                if (cost >= ans) break;

                int used = 0;
                for (int position : state.positions) used |= 1 << position;

                for (int i = 0; i < 16; i++) {
                    if ((state.stopMask >> i & 1) != 0) continue; //already in final position
                    int u = state.positions[i];

                    int otherMask = 0;
                    for (int j = i / 4 * 4, k = 0; k < 4; j++, k++) otherMask |= 1 << state.positions[j];

                    if (u < 16) {
                        // it's in bottom, try to pull out
                        for (int v = 16; v < totalPlaces; v++) {
                            if ((used & path[u][v]) != 1 << u) continue; //path is empty
                            int[] newPositions = Arrays.copyOf(state.positions, 16);
                            newPositions[i] = v;
                            int moveCost = dist[u][v] * stepCost[i / 4];
                            State newState = new State(state, moveCost, newPositions, state.stopMask);
                            newState.canonize(i);
                            Integer previousCost = costMap.getOrDefault(newState, Integer.MAX_VALUE);
                            int newCost = cost + moveCost;
                            if (newCost < previousCost) {
                                costMap.put(newState, newCost);
                                pq.offer(new QueueElement(newState, newCost));
                            }
                        }
                    } else {
                        //it's in top, try to pull in
                        for (int v = 0; v < 16; v++) {
                            if ((used & path[u][v]) != 1 << u) continue; //path is not empty
                            if (i / 4 != v % 4) continue; //don't place in wrong column
                            if (v < 12) {
                                // don't place on wrong ball
                                boolean ok = true;
                                int row = v / 4;
                                int col = v % 4;
                                for (int j = row + 1; j < 4; j++) ok &= (otherMask >>> (j * 4 + col) & 1) != 0;
                                if (!ok) continue;
                            }
                            int[] newPositions = Arrays.copyOf(state.positions, 16);
                            newPositions[i] = v;
                            int moveCost = dist[u][v] * stepCost[i / 4];
                            State newState = new State(state, moveCost, newPositions, state.stopMask);
                            newState.stopMask |= 1 << i;
                            newState.canonize(i);
                            Integer previousCost = costMap.getOrDefault(newState, Integer.MAX_VALUE);
                            int newCost = cost + moveCost;
                            if (newCost < previousCost) {
                                costMap.put(newState, newCost);
                                pq.offer(new QueueElement(newState, newCost));
                                boolean isFinal = Arrays.equals(finalPosition, newPositions);
                                if (isFinal && ans > newCost) {
                                    ans = newCost;
                                    minPath = newState;
                                }
                            }
                        }
                    }
                }
            }
            printer.println(ans);
            printer.println(minPath);
        }
    }

    private static class State {
        final State from;
        final int cost;
        final int[] positions;
        int stopMask;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            State state = (State) o;
            return stopMask == state.stopMask && Arrays.equals(positions, state.positions);
        }

        @Override
        public int hashCode() {
            int result = Objects.hash(stopMask);
            result = 31 * result + Arrays.hashCode(positions);
            return result;
        }

        public State(State from, int cost, int[] positions, int stopMask) {
            this.from = from;
            this.cost = cost;
            this.positions = positions;
            this.stopMask = stopMask;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            State tmp = this;
            while (tmp != null) {
                sb.append("State{positions=").append(Arrays.toString(tmp.positions))
                        .append(", cost = ").append(tmp.cost).append("}\n");
                tmp = tmp.from;
            }
            return sb.toString();
        }

        void canonize(int c) {
            int start = c / 4 * 4;
            for (int i = 3; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (positions[start + j] > positions[start + j + 1]) {
                        int tmp = positions[start + j + 1];
                        positions[start + j + 1] = positions[start + j];
                        positions[start + j] = tmp;
                        stopMask = swapBits(stopMask, start + j + 1, start + j);
                    }
                }
            }
        }
    }

    private static class QueueElement {
        final State state;
        final int cost;

        public QueueElement(State state, int cost) {
            this.state = state;
            this.cost = cost;
        }
    }

    static void prepare() {
        for (int[] arr : dist) Arrays.fill(arr, totalPlaces);
        for (int i = 0; i < totalPlaces; i++) {
            dist[i][i] = 0;
            path[i][i] = 1 << i;
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], d = edge[2];
            dist[u][v] = d;
            dist[v][u] = d;
        }

        for (int j = 0; j < totalPlaces; j++) {
            for (int i = 0; i < totalPlaces; i++) {
                for (int k = 0; k < totalPlaces; k++) {
                    dist[i][k] = Math.min(dist[i][k], dist[i][j] + dist[j][k]);
                }
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[0]));
        for (int i = 0; i < totalPlaces; i++) {
            for (int j = 0; j < i; j++) {
                pq.offer(new int[]{dist[i][j], i, j});
            }
        }

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int d = poll[0], i = poll[1], k = poll[2];
            for (int j = 0; j < totalPlaces; j++) {
                if (dist[i][j] + dist[j][k] == d) {
                    path[i][k] |= path[i][j] | path[j][k];
                    path[k][i] |= path[i][j] | path[j][k];
                }
            }
        }
    }

    static int swapBits(int mask, int i, int j) {
        return mask & ~(1 << i) & ~(1 << j) | (mask >> i & 1) << j | (mask >> j & 1) << i;
    }
}
