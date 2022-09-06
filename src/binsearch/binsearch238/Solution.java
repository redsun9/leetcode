package binsearch.binsearch238;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public boolean solve(int[][] trips, int capacity) {
        PriorityQueue<int[]> pqWait = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
        PriorityQueue<int[]> pqSeat = new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));

        int currentSeat = 0;
        for (int[] trip : trips) pqWait.offer(trip);

        while (!pqWait.isEmpty()) {
            int[] poll = pqWait.poll();
            int time = poll[0];
            while (!pqSeat.isEmpty() && pqSeat.peek()[1] <= time) currentSeat -= pqSeat.poll()[2];
            currentSeat += poll[2];
            if (currentSeat > capacity) return false;
            pqSeat.offer(poll);
        }
        return true;
    }
}
