package leetcode.leetcode10xx.leetcode1046;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(stones.length, Comparator.reverseOrder());
        for (int stone : stones) {
            queue.add(stone);
        }
        while (!queue.isEmpty()) {
            int a = queue.poll();
            if (queue.isEmpty()) return a;
            int b = queue.poll();
            if (a != b) {
                queue.add(a - b);
            }
        }
        return 0;
    }
}
