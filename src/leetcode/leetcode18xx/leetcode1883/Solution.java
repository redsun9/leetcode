package leetcode.leetcode18xx.leetcode1883;

public class Solution {
    public int minSkips(int[] dist, long speed, long hoursBefore) {
        long maxDistance = speed * hoursBefore;
        long total = 0;
        for (int d : dist) total += d;
        if (maxDistance < total) return -1;

        int n = dist.length;
        long[] next = new long[n + 1], prev = new long[n + 1];
        for (int i = 0; i < n; i++) next[i + 1] = (dist[i] + next[i] + speed - 1) / speed * speed;
        int k = 0;
        while (next[n] > maxDistance) {
            long[] tmp = next;
            next = prev;
            prev = tmp;
            k++;
            for (int i = 0; i < n; i++) {
                next[i + 1] = Math.min((dist[i] + next[i] + speed - 1) / speed * speed, dist[i] + prev[i]);
            }
        }
        return k;
    }
}
