package leetcode.leetcode20xx.leetcode2080;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class RangeFreqQuery {
    private final HashMap<Integer, Integer> leftMap = new HashMap<>();
    private final HashMap<Integer, Integer> rightMap = new HashMap<>();
    private final int[][] a;

    public RangeFreqQuery(int[] arr) {
        int n = arr.length;
        this.a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = arr[i];
            a[i][1] = i;
        }
        Arrays.sort(a, Comparator.comparingInt((int[] x) -> x[0]).thenComparingInt(x -> x[1]));

        for (int i = 0; i < n; i++) {
            leftMap.putIfAbsent(a[i][0], i);
            rightMap.put(a[i][0], i);
        }
    }

    public int query(int left, int right, int value) {
        Integer leftPos = leftMap.get(value);
        if (leftPos == null) return 0;
        Integer rightPos = rightMap.get(value);
        int lo1 = leftPos - 1, hi1 = rightPos;
        while (lo1 < hi1) {
            int mid = (lo1 + hi1 + 1) / 2;
            if (a[mid][0] > value || a[mid][0] == value && a[mid][1] >= left) hi1 = mid - 1;
            else lo1 = mid;
        }

        int lo2 = lo1 + 1, hi2 = rightPos + 1;
        while (lo2 < hi2) {
            int mid = (lo2 + hi2) / 2;
            if (a[mid][0] < value || a[mid][0] == value && a[mid][1] <= right) lo2 = mid + 1;
            else hi2 = mid;
        }
        return lo2 - lo1 - 1;
    }
}
