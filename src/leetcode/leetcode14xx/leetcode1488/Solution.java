package leetcode.leetcode14xx.leetcode1488;

import java.util.HashMap;
import java.util.TreeSet;

public class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        HashMap<Integer, Integer> lastFloodMap = new HashMap<>(); //lake->day
        TreeSet<Integer> dryDays = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                dryDays.add(i);
                ans[i] = 1;
            } else {
                ans[i] = -1;
                if (lastFloodMap.containsKey(rains[i])) {
                    Integer ceiling = dryDays.ceiling(lastFloodMap.get(rains[i]));
                    if (ceiling != null) {
                        dryDays.remove(ceiling);
                        ans[ceiling] = rains[i];
                        lastFloodMap.put(rains[i], i);
                    } else return new int[0];
                } else {
                    lastFloodMap.put(rains[i], i);
                }
            }
        }
        return ans;
    }
}
