package leetcode.leetcode9xx.leetcode962;

import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public int maxWidthRamp(int[] a) {
        int n = a.length;
        if (n < 2) return 0;
        int ans = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int max = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            int num = a[i];
            if (num <= max) {
                Map.Entry<Integer, Integer> entry = map.ceilingEntry(num);
                ans = Math.max(ans, entry.getValue() - i);
            } else if (num > max) {
                map.put(num, i);
                max = num;
            }
        }
        return ans;
    }
}
