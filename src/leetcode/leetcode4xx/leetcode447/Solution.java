package leetcode.leetcode4xx.leetcode447;

import java.util.HashMap;

public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        for (int[] center : points) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int[] point : points) {
                int dist = (center[0] - point[0]) * (center[0] - point[0]) + (center[1] - point[1]) * (center[1] - point[1]);
                int count = map.getOrDefault(dist, 0);
                ans += count;
                map.put(dist, count + 1);
            }
        }
        return ans * 2;
    }
}
