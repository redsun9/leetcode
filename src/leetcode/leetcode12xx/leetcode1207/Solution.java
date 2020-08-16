package leetcode.leetcode12xx.leetcode1207;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int a : arr) counts.put(a, counts.getOrDefault(a, 0) + 1);
        Set<Integer> set = new HashSet<>();
        for (Integer val : counts.values()) {
            if (!set.add(val)) return false;
        }
        return true;
    }
}
