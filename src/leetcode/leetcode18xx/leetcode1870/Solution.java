package leetcode.leetcode18xx.leetcode1870;

public class Solution {
    private static boolean check(int[] dist, long speed, long centHour) {
        for (int i = 0; i < dist.length - 1; i++) {
            centHour -= (dist[i] + speed - 1) / speed * 100;
            if (centHour <= 0) return false;
        }
        return centHour * speed >= dist[dist.length - 1] * 100L;
    }

    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        long centHour = Math.round(hour * 100);
        if (n == 1) return (int) ((dist[0] * 100 + centHour - 1) / centHour);
        if ((n - 1) * 100L >= centHour) return -1;
        int maxDist = 0;
        long totalDist = 0;
        for (int i = 0; i < n - 1; i++) maxDist = Math.max(maxDist, dist[i]);
        for (int j : dist) totalDist += j;
        long lo = (totalDist * 100 + centHour - 1) / centHour;
        long hi = Math.max(maxDist, (dist[n - 1] * 100L + centHour - 100L * (n - 1) - 1) / (centHour - 100L * (n - 1)));
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (check(dist, mid, centHour)) hi = mid;
            else lo = mid + 1;
        }
        return (int) lo;
    }
}
