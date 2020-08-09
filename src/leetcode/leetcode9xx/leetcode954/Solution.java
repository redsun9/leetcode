package leetcode.leetcode9xx.leetcode954;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public boolean canReorderDoubled(int[] nums) {
        PriorityQueue<Integer> posQueue = new PriorityQueue<>();
        PriorityQueue<Integer> negQueue = new PriorityQueue<>(Comparator.reverseOrder());
        HashMap<Integer, Integer> countMap = new HashMap<>();

        for (int a : nums) countMap.put(a, countMap.getOrDefault(a, 0) + 1);

        for (Integer a : countMap.keySet()) {
            if (a > 0) posQueue.offer(a);
            else if (a < 0) negQueue.offer(a);
            else if (countMap.get(a) % 2 != 0) return false;
        }

        for (PriorityQueue<Integer> pq : List.of(posQueue, negQueue)) {
            while (!pq.isEmpty()) {
                int poll = pq.poll();
                int count = countMap.get(poll);
                int left = countMap.getOrDefault(poll * 2, 0) - count;
                if (left < 0) return false;
                countMap.put(poll * 2, left);
            }
        }
        return true;
    }
}
