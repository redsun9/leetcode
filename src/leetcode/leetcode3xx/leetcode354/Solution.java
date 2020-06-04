package leetcode.leetcode3xx.leetcode354;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length < 2) return envelopes.length;
        Arrays.sort(envelopes, Comparator.comparingInt((int[] x) -> x[0]).thenComparingInt(x -> -x[1]));
        return lis(envelopes, Comparator.comparingInt(x -> x[1]));
    }


    private static <V> int lis(V[] arr, Comparator<V> cmp) {
        int ans = 0;
        for (V v : arr) {
            int lo = 0, hi = ans;
            while (lo != hi) {
                int mid = lo + (hi - lo) / 2;
                if (cmp.compare(arr[mid], v) < 0) lo = mid + 1;
                else hi = mid;
            }
            arr[lo] = v;
            if (lo == ans) ans++;
        }
        return ans;
    }
}
