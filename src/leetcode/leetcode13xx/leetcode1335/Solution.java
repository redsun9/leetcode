package leetcode.leetcode13xx.leetcode1335;

import java.util.ArrayDeque;

// O(n*d) solution
public class Solution {
    public static final int INF = 1_000_000_000;

    public int minDifficulty(int[] jobs, int days) {
        int n = jobs.length;
        if (n == 0 && days == 0) return 0;
        if (n < days || days == 0) return -1;
        int ans = 0;
        if (n == days) {
            for (int j : jobs) ans += j;
        } else if (days == 1) {
            for (int j : jobs) ans = Math.max(ans, j);
        } else {
            int[] prev = new int[n];
            int[] next = new int[n];
            prev[0] = jobs[0];
            for (int i = 1; i < n; i++) prev[i] = Math.max(prev[i - 1], jobs[i]);

            for (int d = 1; d < days; d++) {
                ArrayDeque<int[]> ms = new ArrayDeque<>();
                ms.offer(new int[]{INF, INF, INF});

                for (int i = d; i <= n + d - days; i++) {
                    int prevMin = prev[i - 1];
                    while (ms.peekLast()[1] <= jobs[i]) prevMin = Math.min(prevMin, ms.pollLast()[0]);
                    ms.offerLast(new int[]{prevMin, jobs[i], Math.min(prevMin + jobs[i], ms.peekLast()[2])});
                    next[i] = ms.peekLast()[2];
                }
                int[] tmp = prev;
                prev = next;
                next = tmp;
            }
            ans = prev[n - 1];
        }
        return ans;
    }
}
