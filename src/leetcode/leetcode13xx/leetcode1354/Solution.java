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
            pq.add(a);
        }
        while (pq.peek() != 1) {
            int poll = pq.poll();
            if (2 * poll - s < 1) return false;
            s -= poll;
            if (s <= 0) return false;
            if (s == 1) return true;
            int a = poll % (int) s;
            pq.add(a);
            s += a;
        }
        return true;
    }
}
