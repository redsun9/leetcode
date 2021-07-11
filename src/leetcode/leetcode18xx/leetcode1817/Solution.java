package leetcode.leetcode18xx.leetcode1817;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] log : logs) {
            map.compute(log[0], (key, val) -> {
                if (val == null) val = new HashSet<>();
                val.add(log[1]);
                return val;
            });
        }
        int[] ans = new int[k];
        for (Set<Integer> set : map.values()) {
            int size = set.size();
            if (size <= k) ans[size - 1]++;
        }
        return ans;
    }
}
