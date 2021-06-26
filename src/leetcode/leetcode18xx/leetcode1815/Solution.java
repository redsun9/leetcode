package leetcode.leetcode18xx.leetcode1815;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    private static int dfs(int[][] tmp, int n, int curr, int batchSize, int left, Map<Key, Integer> cache) {
        if (left == 0) return 0;
        Key key = new Key(tmp[0]);
        Integer ans = cache.get(key);
        if (ans == null) {
            int max = 0;
            for (int i = 0; i < n; i++) {
                if (tmp[0][i] != 0) {
                    tmp[0][i]--;
                    max = Math.max(max, dfs(tmp, n, (curr + tmp[1][i]) % batchSize, batchSize, left - 1, cache));
                    tmp[0][i]++;
                }
            }
            ans = (curr == 0 ? 1 : 0) + max;
            cache.put(key, ans);
        }
        return ans;
    }

    public int maxHappyGroups(int batchSize, int[] groups) {
        if (batchSize == 1) return groups.length;
        int[] counters = new int[batchSize];
        for (int group : groups) counters[group % batchSize]++;
        int ans = counters[0];
        counters[0] = 0;
        for (int i = 1, j = batchSize - 1; i < j; i++, j--) {
            int a = Math.min(counters[i], counters[j]);
            ans += a;
            counters[i] -= a;
            counters[j] -= a;
        }
        if (batchSize % 2 == 0) {
            ans += counters[batchSize / 2] / 2;
            counters[batchSize / 2] %= 2;
        }
        int leftDiff = 0, leftTotal = 0;
        for (int counter : counters) {
            if (counter != 0) {
                leftDiff++;
                leftTotal += counter;
            }
        }
        if (leftDiff == 0) return ans;
        int[][] tmp = new int[2][leftDiff];
        for (int i = 1, pos = 0; i < batchSize; i++) {
            if (counters[i] != 0) {
                tmp[0][pos] = counters[i];
                tmp[1][pos++] = i;
            }
        }
        return ans + dfs(tmp, leftDiff, 0, batchSize, leftTotal, new HashMap<>());
    }

    private static class Key {
        private final int[] a;

        private Key(int[] a) {
            this.a = a.clone();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return Arrays.equals(a, key.a);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(a);
        }
    }
}
