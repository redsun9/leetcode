package advent.year2021.day23.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;


@SuppressWarnings({"DuplicatedCode"})
public class Solution {

    /*
            89*A*B*C*DE
            ##0#1#2#3##
            ##4#5#6#7##
     */

    private static final int[] finalPosition = {0, 4, 1, 5, 2, 6, 3, 7};
    private static final int totalPlaces = 15;
    private static final int[] stepCost = {1, 10, 100, 1000};
    private static final int[][] edges = {
            {0, 4, 1}, {1, 5, 1}, {2, 6, 1}, {3, 7, 1},
            {8, 9, 1},
            {9, 0, 2}, {9, 10, 2}, {0, 10, 2},
            {10, 1, 2}, {1, 11, 2}, {10, 11, 2},
            {11, 2, 2}, {11, 12, 2}, {2, 12, 2},
            {12, 3, 2}, {3, 13, 2}, {12, 13, 2},
            {13, 14, 1}
    };

    private static final int[][] dist = new int[totalPlaces][totalPlaces];
    private static final int[][] path = new int[totalPlaces][totalPlaces];


    public static void main(String[] args) throws IOException {
        prepare();
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2021/day23/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2021/day23/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            scanner.nextLine();
            scanner.nextLine();

            int[] startingPositions = new int[8];
            Arrays.fill(startingPositions, -1);
            for (int i = 0, pos = 0; i < 2; i++) {
                String s = scanner.nextLine();
                for (int j = 0; j < 4; j++, pos++) {
                    int c = s.charAt(3 + j * 2) - 'A';
                    if (startingPositions[c * 2] == -1) startingPositions[c * 2] = pos;
                    else startingPositions[c * 2 + 1] = pos;
                }
            }

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

                for (int i = 0; i < 8; i++) {
                    if ((state.stopMask >> i & 1) != 0) continue; //already in final position
                    int u = state.positions[i];
                    int another = state.positions[i ^ 1];

                    if (u < 8) {
                        // it's in bottom, try to pull out
                        for (int v = 8; v < 15; v++) {
                            if ((used & path[u][v]) != 1 << u) continue; //path is empty
                            int[] newPositions = Arrays.copyOf(state.positions, 8);
                            newPositions[i] = v;
                            int moveCost = dist[u][v] * stepCost[i / 2];
                            State newState = new State(state, moveCost, newPositions, state.stopMask);
                            if ((u < another) ^ (v < another)) { //need swap i and  i^1
                                int tmp = newPositions[i];
                                newPositions[i] = newPositions[i ^ 1];
                                newPositions[i ^ 1] = tmp;
                                newState.stopMask = swapBits(newState.stopMask, i, i ^ 1);
                            }
                            Integer previousCost = costMap.getOrDefault(newState, Integer.MAX_VALUE);
                            int newCost = cost + moveCost;
                            if (newCost < previousCost) {
                                costMap.put(newState, newCost);
                                pq.offer(new QueueElement(newState, newCost));
                            }
                        }
                    } else {
                        //it's in top, try to pull in
                        for (int v = 0; v < 8; v++) {
                            if ((used & path[u][v]) != 1 << u) continue; //path is not empty
                            if (v < 4 && another != v + 4) continue; // don't place on wrong ball
                            int[] newPositions = Arrays.copyOf(state.positions, 8);
                            newPositions[i] = v;
                            int moveCost = dist[u][v] * stepCost[i / 2];
                            State newState = new State(state, moveCost, newPositions, state.stopMask);
                            newState.stopMask |= 1 << i;
                            if ((u < another) ^ (v < another)) { //need swap i& i^1
                                int tmp = newPositions[i];
                                newPositions[i] = newPositions[i ^ 1];
                                newPositions[i ^ 1] = tmp;
                                newState.stopMask = swapBits(newState.stopMask, i, i ^ 1);
                            }
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
    }

    private record QueueElement(State state, int cost) {
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
