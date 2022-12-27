package leetcode.leetcode25xx.leetcode2508;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public boolean isPossible(int n, List<List<Integer>> edges) {
        int[] cnt = new int[n];
        Set<Pair> set = new HashSet<>();
        for (List<Integer> edge : edges) {
            int u = edge.get(0) - 1, v = edge.get(1) - 1;
            set.add(new Pair(u, v));
            set.add(new Pair(v, u));
            cnt[u]++;
            cnt[v]++;
        }
        List<Integer> oddPoints = new ArrayList<>();
        for (int i = 0; i < n; i++) if ((cnt[i] & 1) == 1) oddPoints.add(i);
        if (oddPoints.isEmpty()) return true;
        if (oddPoints.size() > 4) return false;

        if (oddPoints.size() == 4) {
            int a = oddPoints.get(0), b = oddPoints.get(1), c = oddPoints.get(2), d = oddPoints.get(3);
            return !set.contains(new Pair(a, b)) && !set.contains(new Pair(c, d)) ||
                    !set.contains(new Pair(a, c)) && !set.contains(new Pair(b, d)) ||
                    !set.contains(new Pair(a, d)) && !set.contains(new Pair(b, c));
        } else {
            int a = oddPoints.get(0), b = oddPoints.get(1);
            if (!set.contains(new Pair(a, b))) return true;
            for (int c = 0; c < n; c++) {
                if (!set.contains(new Pair(a, c)) && !set.contains(new Pair(b, c))) return true;
            }
            return false;
        }
    }

    private record Pair(int a, int b) {
    }
}
