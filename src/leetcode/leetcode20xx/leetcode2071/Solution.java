package leetcode.leetcode20xx.leetcode2071;

import java.util.Arrays;
import java.util.TreeMap;

public class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int lo = 0, hi = Math.min(tasks.length, workers.length);
        while (lo < hi) {
            int mid = (lo + hi + 1) / 2;
            if (check(mid, tasks, workers, pills, strength)) lo = mid;
            else hi = mid - 1;
        }
        return lo;
    }

    @SuppressWarnings("ConstantConditions")
    private static boolean check(int n, int[] tasks, int[] workers, int p, int s) {
        TreeMap<Integer, Integer> countMap = new TreeMap<>();
        int m = workers.length;

        for (int i = m - n; i < m; i++) countMap.compute(workers[i], (k, oldVal) -> oldVal == null ? 1 : oldVal + 1);

        while (n > 0) {
            int task = tasks[--n];
            Integer key;
            if (task <= countMap.lastKey()) {
                key = countMap.lastKey();
            } else {
                key = countMap.ceilingKey(task - s);
                if (key == null || p-- == 0) return false;
            }
            countMap.compute(key, (k, oldVal) -> oldVal == 1 ? null : oldVal - 1);
        }
        return true;
    }
}
