package leetcode.leetcode16xx.leetcode1636;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByKey;
import static java.util.Map.Entry.comparingByValue;

public class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : nums) count.compute(num, (k, v) -> v == null ? 1 : v + 1);
        Comparator<Map.Entry<Integer, Integer>> valueComparator = comparingByValue();
        Comparator<Map.Entry<Integer, Integer>> keyComparator = comparingByKey();
        List<Map.Entry<Integer, Integer>> list = count.entrySet().stream()
                .sorted(
                        valueComparator.thenComparing(keyComparator.reversed()))
                .collect(Collectors.toList());
        int[] ans = new int[nums.length];
        int pos = 0;
        for (Map.Entry<Integer, Integer> entry : list) {
            Integer key = entry.getKey();
            for (int i = entry.getValue(); i > 0; i--) {
                ans[pos++] = key;
            }
        }
        return ans;
    }
}
