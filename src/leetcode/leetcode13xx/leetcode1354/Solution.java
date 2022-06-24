package leetcode.leetcode13xx.leetcode1354;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long s = 0;
        for (int a : target) {
            if (a <= 0) return false;
            s += a;
            if (a != 1) pq.add(a);
        }
        while (!pq.isEmpty()) {
            int poll = pq.poll();
            if (2L * poll - s < 1) return false;
            s -= poll;
            if (s <= 0) return false;
            if (s == 1) return true;
            poll = poll % (int) s;
            if (poll == 0) return false;
            if (poll != 1) pq.add(poll);
            s += poll;
        }
        return true;
    }
}
