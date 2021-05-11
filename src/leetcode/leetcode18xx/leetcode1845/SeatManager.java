package leetcode.leetcode18xx.leetcode1845;

import java.util.PriorityQueue;

public class SeatManager {
    private final PriorityQueue<Integer> pq;

    public SeatManager(int n) {
        pq = new PriorityQueue<>(n);
        for (int i = 1; i <= n; i++) pq.offer(i);
    }

    @SuppressWarnings("ConstantConditions")
    public int reserve() {
        return pq.poll();
    }

    public void unreserve(int seatNumber) {
        pq.offer(seatNumber);
    }
}
