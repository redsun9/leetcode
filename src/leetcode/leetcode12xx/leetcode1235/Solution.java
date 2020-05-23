package leetcode.leetcode12xx.leetcode1235;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, Comparator.comparingInt(x -> endTime[x]));
        TreeMap<Integer, Integer> dp = new TreeMap<>();
        dp.put(0, 0);
        for (Integer index : indices) {
            int tmp = dp.floorEntry(startTime[index]).getValue() + profit[index];
            if (tmp > dp.lastEntry().getValue()) dp.put(endTime[index], tmp);
        }
        return dp.lastEntry().getValue();
    }
}
