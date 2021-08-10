package leetcode.leetcode7xx.leetcode781;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int answer : answers) map.compute(answer, (k, v) -> v == null ? 1 : v + 1);
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans += (entry.getValue() + entry.getKey()) / (entry.getKey() + 1) * (entry.getKey() + 1);
        }
        return ans;
    }
}
