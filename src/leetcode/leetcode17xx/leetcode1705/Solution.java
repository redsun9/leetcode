package leetcode.leetcode17xx.leetcode1705;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int eatenApples(int[] apples, int[] days) {
        int n = apples.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[0]));
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (apples[i] != 0) pq.offer(new int[]{i + days[i], apples[i]});
            while (!pq.isEmpty() && pq.peek()[0] <= i) pq.poll();
            if (!pq.isEmpty()) {
                ans++;
                int[] poll = pq.poll();
                if (--poll[1] > 0) pq.offer(poll);
            }
        }
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int eaten = Math.max(0, Math.min(poll[1], poll[0] - n));
            ans += eaten;
            n += eaten;
        }
        return ans;
    }
}
