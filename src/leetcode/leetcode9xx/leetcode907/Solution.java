package leetcode.leetcode9xx.leetcode907;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

@SuppressWarnings({"DuplicatedCode", "ConstantConditions"})
public class Solution {
    private static final int p = 1_000_000_007;

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[][] pq = new int[n][2];
        for (int i = 0; i < n; i++) {
            pq[i][0] = arr[i];
            pq[i][1] = i;
        }
        Arrays.sort(pq, Comparator.comparingInt(x -> x[0]));
        TreeSet<Integer> set = new TreeSet<>();
        set.add(-1);
        set.add(n);
        long ans = 0;
        for (int[] pair : pq) {
            int l = set.floor(pair[1]), r = set.ceiling(pair[1]);
            set.add(pair[1]);
            ans += (long) (pair[1] - l) * (r - pair[1]) * pair[0];
        }
        return (int) (ans % p);
    }
}
