package leetcode.leetcode9xx.leetcode975;

import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public int oddEvenJumps(int[] a) {
        int n = a.length;
        int res = 1;
        boolean[] even = new boolean[n];
        boolean[] odd = new boolean[n];
        even[n - 1] = true;
        odd[n - 1] = true;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(a[n - 1], n - 1);
        for (int i = n - 2; i >= 0; i--) {
            Map.Entry<Integer, Integer> ceilingEntry = map.ceilingEntry(a[i]);
            Map.Entry<Integer, Integer> floorEntry = map.floorEntry(a[i]);
            if (ceilingEntry != null) even[i] = odd[ceilingEntry.getValue()];
            if (floorEntry != null) odd[i] = even[floorEntry.getValue()];
            if (even[i]) res++;
            map.put(a[i], i);
        }
        return res;
    }
}
