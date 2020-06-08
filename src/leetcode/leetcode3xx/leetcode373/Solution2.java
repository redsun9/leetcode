package leetcode.leetcode3xx.leetcode373;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import static java.util.Comparator.comparingInt;

public class Solution2 {
    public List<List<Integer>> kSmallestPairs(int[] a, int[] b, int k) {
        int n1 = a.length;
        int n2 = b.length;
        if (n1 == 0 || n2 == 0 || k == 0) return Collections.emptyList();
        List<List<Integer>> ans = new ArrayList<>(Math.min(n1 * n2, k));
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(comparingInt(x -> x.get(2)));
        for (int i = Math.min(n1, k) - 1; i >= 0; i--) pq.offer(List.of(i, 0, a[i] + b[0]));
        while (k-- > 0 && !pq.isEmpty()) {
            List<Integer> poll = pq.poll();
            Integer i = poll.get(0);
            Integer j = poll.get(1);
            ans.add(List.of(a[i], b[j]));
            if (j + 1 < n2) pq.offer(List.of(i, j + 1, a[i] + b[j + 1]));
        }
        return ans;
    }
}
