package leetcode.leetcode17xx.leetcode1751;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, Comparator.comparingInt(x -> x[1]));
        TreeMap<Integer, Integer>[] maps = new TreeMap[k + 1];
        for (int i = 0; i <= k; i++) {
            maps[i] = new TreeMap<>();
            maps[i].put(0, 0);
        }
        int[] dp = new int[k];
        for (int[] event : events) {
            for (int j = k; j >= 1; j--) {
                int floor = maps[j - 1].floorEntry(event[0] - 1).getValue() + event[2];
                if (floor > dp[j - 1]) {
                    maps[j].put(event[1], floor);
                    dp[j - 1] = floor;
                }
            }
        }
        int ans = 0;
        for (int a : dp) ans = Math.max(ans, a);
        return ans;
    }
}
