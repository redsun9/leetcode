package leetcode.leetcode11xx.leetcode1157;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityChecker {
    private final int[] t, lb, rb;
    private final int n;
    private final Map<Integer, List<Integer>> map = new HashMap<>();

    public MajorityChecker(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            List<Integer> list = map.computeIfAbsent(arr[i], k -> new ArrayList<>());
            list.add(i);
        }
        n = nextPow2(arr.length);
        t = new int[n * 2 - 1];
        lb = new int[n * 2 - 1];
        rb = new int[n * 2 - 1];
        System.arraycopy(arr, 0, t, n - 1, arr.length);
        for (int i = 0, j = n - 1; i < n; i++, j++) {
            lb[j] = i;
            rb[j] = i + 1;
        }

        for (int i = n - 2, i1 = 2 * i + 1, i2 = 2 * i + 2; i >= 0; i--, i1 -= 2, i2 -= 2) {
            lb[i] = lb[i1];
            rb[i] = rb[i2];
            int len = rb[i] - lb[i];
            int majority = len / 2 + 1;
            if (t[i1] != 0) {
                int count = getCount(map.get(t[i1]), lb[i], rb[i]);
                if (count >= majority) {
                    t[i] = t[i1];
                    continue;
                }
            }
            if (t[i2] != 0 && t[i2] != t[i1]) {
                int count = getCount(map.get(t[i2]), lb[i], rb[i]);
                if (count >= majority) {
                    t[i] = t[i2];
                }
            }
        }
    }

    public static int getCount(List<Integer> list, int left, int right) {
        int lo = -1, hi = list.size() - 1;
        while (lo < hi) {
            int mid = (lo + hi + 1) / 2;
            if (list.get(mid) >= left) hi = mid - 1;
            else lo = mid;
        }
        int start = lo;

        lo = 0;
        hi = list.size();
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (list.get(mid) < right) lo = mid + 1;
            else hi = mid;
        }
        return lo - start - 1;
    }

    private static int nextPow2(int n) {
        if ((n & (n - 1)) == 0) return n;
        else return Integer.highestOneBit(n) << 1;
    }

    public int query(int left, int right, int threshold) {
        List<Integer> candidates = new ArrayList<>();
        getCandidates(0, left, right + 1, candidates);
        for (Integer candidate : candidates) {
            if (getCount(map.get(candidate), left, right + 1) >= threshold) return candidate;
        }
        return -1;
    }

    private void getCandidates(int v, int ql, int qr, List<Integer> candidates) {
        if (qr <= lb[v] || rb[v] <= ql) return;
        if (ql <= lb[v] && rb[v] <= qr) {
            if (t[v] != 0) candidates.add(t[v]);
        } else {
            getCandidates(v * 2 + 1, ql, qr, candidates);
            getCandidates(v * 2 + 2, ql, qr, candidates);
        }
    }
}
