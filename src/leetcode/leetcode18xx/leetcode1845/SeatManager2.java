package leetcode.leetcode18xx.leetcode1845;

import java.util.PriorityQueue;

public class SeatManager2 {
    private final PriorityQueue<Integer> pq;
    private int maxReserved;

    public SeatManager2(int n) {
        pq = new PriorityQueue<>();
        maxReserved = 0;
    }

    public int reserve() {
        if (!pq.isEmpty()) return pq.poll();
        return ++maxReserved;
    }

    public void unreserve(int seatNumber) {
        pq.offer(seatNumber);
    }
}
