package leetcode.leetcode9xx.leetcode933;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {
    private final int threshold = 3000;
    private Queue<Integer> queue = new LinkedList<>();

    public int ping(int t) {
        queue.add(t);
        while (!queue.isEmpty() && queue.peek() < t - 3000) queue.poll();
        return queue.size();
    }
}
