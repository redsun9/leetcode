package leetcode.leetcode8xx.leetcode822;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        Set<Integer> set = new HashSet<>();
        int n = fronts.length;
        for (int i = 0; i < n; i++) if (fronts[i] == backs[i]) set.add(fronts[i]);

        int ans = Integer.MAX_VALUE;
        for (int val : fronts) if (!set.contains(val)) ans = Math.min(ans, val);
        for (int val : backs) if (!set.contains(val)) ans = Math.min(ans, val);
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
