package leetcode.leetcode24xx.leetcode2402;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

@SuppressWarnings("ConstantConditions")
public class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int[] count = new int[n];
        PriorityQueue<Integer> free = new PriorityQueue<>();
        PriorityQueue<BookingInfo> booked = new PriorityQueue<>(Comparator.comparingLong(x -> x.time));
        long time = 0;
        for (int i = 0; i < n; i++) free.offer(i);
        Arrays.sort(meetings, Comparator.comparingInt(x -> x[0]));
        for (int[] meeting : meetings) {
            long duration = meeting[1] - meeting[0];
            time = Math.max(time, meeting[0]);
            if (free.isEmpty()) time = Math.max(time, booked.peek().time);
            while (!booked.isEmpty() && booked.peek().time <= time) free.offer(booked.poll().roomId);
            Integer roomId = free.poll();
            count[roomId]++;
            booked.offer(new BookingInfo(roomId, time + duration));
        }

        int maxCnt = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            if (maxCnt < count[i]) {
                maxCnt = count[i];
                ans = i;
            }
        }
        return ans;
    }

    private record BookingInfo(int roomId, long time) {
    }
}
