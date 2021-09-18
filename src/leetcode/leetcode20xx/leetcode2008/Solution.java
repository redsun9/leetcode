package leetcode.leetcode20xx.leetcode2008;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, Comparator.comparingInt(x -> x[1]));
        TreeMap<Integer, Long> map = new TreeMap<>();
        map.put(0, 0L);
        long ans = 0;
        for (int[] ride : rides) {
            Map.Entry<Integer, Long> floor = map.floorEntry(ride[0]);
            long tmp = (floor != null ? floor.getValue() : 0) + ride[1] - ride[0] + ride[2];
            if (tmp > ans) {
                ans = tmp;
                map.put(ride[1], ans);
            }
        }
        return ans;
    }
}
