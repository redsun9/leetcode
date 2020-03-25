package leetcode.leetcode403;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        if (n == 0) return false;
        int lastStone = stones[n - 1];
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>(stones.length * 2);
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 1; i < n - 1; i++) {
            hashSet.add(stones[i]);
        }

        map.put(0, new HashSet<>());
        map.get(0).add(0);
        int maxStone = 0;
        for (int i = 0; i < n - 1; i++) {
            int stone = stones[i];
            if (maxStone < stone) return false;
            HashSet<Integer> set = map.get(stone);
            if (set != null) {
                for (Integer d : set) {
                    int next = stone + d;
                    if (next + 1 == lastStone) return true;
                    if (hashSet.contains(next + 1)) {
                        maxStone = Math.max(next + 1, maxStone);
                        if (!map.containsKey(next + 1)) {
                            map.put(next + 1, new HashSet<>());
                        }
                        map.get(next + 1).add(d + 1);
                    }

                    if (next == lastStone) return true;
                    if (hashSet.contains(next)) {
                        maxStone = Math.max(next, maxStone);
                        if (!map.containsKey(next)) {
                            map.put(next, new HashSet<>());
                        }
                        map.get(next).add(d);
                    }

                    if (d > 1) {
                        if (next - 1 == lastStone) return true;
                        if (hashSet.contains(next - 1)) {
                            maxStone = Math.max(next - 1, maxStone);
                            if (!map.containsKey(next - 1)) {
                                map.put(next - 1, new HashSet<>());
                            }
                            map.get(next - 1).add(d - 1);
                        }
                    }
                }
            }
        }
        return false;
    }
}
