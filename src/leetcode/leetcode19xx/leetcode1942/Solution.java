package leetcode.leetcode19xx.leetcode1942;

import java.util.Comparator;
import java.util.PriorityQueue;

@SuppressWarnings("ConstantConditions")
public class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int targetSitTime = times[targetFriend][0];
        PriorityQueue<int[]> sit = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
        PriorityQueue<int[]> stay = new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));
        PriorityQueue<Integer> available = new PriorityQueue<>();
        int maxOccupied = 0;
        int n = times.length;
        for (int i = 0; i < n; i++) {
            int[] time = times[i];
            if (time[0] > targetSitTime) continue;
            sit.offer(new int[]{time[0], time[1], i, 0});
        }
        while (true) {
            int[] poll = sit.poll();
            int sitTime = poll[0];
            while (!stay.isEmpty() && stay.peek()[1] <= sitTime) available.offer(stay.poll()[3]);
            int seat = !available.isEmpty() ? available.poll() : maxOccupied++;
            if (poll[2] == targetFriend) return seat;
            poll[3] = seat;
            stay.offer(poll);
        }
    }
}
