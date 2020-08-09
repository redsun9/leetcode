package leetcode.leetcode8xx.leetcode823;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    private static final int p = 1_000_000_007;

    public int numFactoredBinaryTrees(int[] a) {
        int n = a.length;
        long ans = 0;
        Arrays.sort(a);
        HashMap<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long count = 1;
            int root = a[i];
            int j = 0;
            while (j < i) {
                int left = a[j];
                if ((long) left * left > (long) root) break;
                if (root % left == 0) {
                    int right = root / left;
                    if (left == right) {
                        count = (count + map.get(left) * map.get(right)) % p;
                    } else if (map.containsKey(right)) {
                        count = (count + map.get(left) * map.get(right) * 2) % p;
                    }
                }
                j++;
            }
            ans = (ans + count) % p;
            map.put(root, count);
        }
        return (int) ans;
    }
}
