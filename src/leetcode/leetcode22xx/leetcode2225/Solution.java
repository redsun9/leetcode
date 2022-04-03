package leetcode.leetcode22xx.leetcode2225;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        TreeMap<Integer, Integer> lostCount = new TreeMap<>();
        for (int[] match : matches) {
            lostCount.putIfAbsent(match[0], 0);
            lostCount.compute(match[1], (k, v) -> v == null ? 1 : v + 1);
        }
        List<Integer> winners = new ArrayList<>();
        List<Integer> losers = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : lostCount.entrySet()) {
            switch (entry.getValue()) {
                case 0 -> winners.add(entry.getKey());
                case 1 -> losers.add(entry.getKey());
            }
        }
        return List.of(winners, losers);
    }
}
