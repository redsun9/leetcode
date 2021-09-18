package leetcode.leetcode20xx.leetcode2007;

import java.util.Map;
import java.util.TreeMap;

@SuppressWarnings("ConstantConditions")
public class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n % 2 != 0 || n == 0) return new int[0];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : changed) map.compute(num, (k, v) -> v == null ? 1 : v + 1);
        int[] ans = new int[n / 2];
        int pos = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 0) continue;
            if (entry.getKey() == 0) pos += entry.getValue() / 2;
            else {
                int key = entry.getKey();
                int val = entry.getValue();
                if (map.getOrDefault(2 * key, 0) < val) return new int[0];
                map.compute(2 * key, (k, v) -> v - val);
                for (int i = 0; i < val; i++) ans[pos++] = key;
            }
        }
        return ans;
    }
}
