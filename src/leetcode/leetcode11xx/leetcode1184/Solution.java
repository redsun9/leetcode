package leetcode.leetcode11xx.leetcode1184;

public class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start == destination) return 0;
        if (start > destination) {
            int tmp = start;
            start = destination;
            destination = tmp;
        }
        int sum = 0;
        for (int dist : distance) sum += dist;

        int ans = 0;
        for (int i = start; i < destination; i++) ans += distance[i];
        return Math.min(ans, sum - ans);
    }
}
