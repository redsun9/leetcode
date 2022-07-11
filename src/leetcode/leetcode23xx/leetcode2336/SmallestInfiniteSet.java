package leetcode.leetcode23xx.leetcode2336;

import java.util.HashSet;
import java.util.PriorityQueue;

public class SmallestInfiniteSet {
    private int lowBound = 1;
    private PriorityQueue<Integer> pq = new PriorityQueue<>();
    private HashSet<Integer> set = new HashSet<>();

    public int popSmallest() {
        if (pq.isEmpty()) return lowBound++;
        int ans = pq.poll();
        set.remove(ans);
        return ans;

    }

    public void addBack(int num) {
        if (num < lowBound && set.add(num)) pq.offer(num);
    }
}
