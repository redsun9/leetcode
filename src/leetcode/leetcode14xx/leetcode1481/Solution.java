package leetcode.leetcode14xx.leetcode1481;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        if (arr.length == 0 || arr.length == k) return 0;
        if (arr.length == k - 1) return 1;

        HashMap<Integer, Integer> count = new HashMap<>();
        for (int a : arr) count.put(a, count.getOrDefault(a, 0) + 1);
        if (k == 0) return count.size();
        PriorityQueue<Integer> pq = new PriorityQueue<>(count.values());
        while (pq.peek() <= k) k -= pq.poll();
        return pq.size();
    }
}
