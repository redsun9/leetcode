package leetcode.leetcode13xx.leetcode1383;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

@SuppressWarnings("ConstantConditions")
public class Solution {
    public static final int p = 1_000_000_007;

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] people = new int[n][2];
        for (int i = 0; i < n; i++) {
            people[i][0] = speed[i];
            people[i][1] = efficiency[i];
        }
        Arrays.sort(people, Comparator.comparingInt(a -> a[1]));
        long ans = 0;
        long sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(k + 1);
        for (int i = n - 1; i >= 0; i--) {
            pq.add(people[i][0]);
            sum += people[i][0];
            if (pq.size() > k) sum -= pq.poll();
            ans = Math.max(ans, sum * people[i][1]);
        }
        return (int) (ans % p);
    }
}
