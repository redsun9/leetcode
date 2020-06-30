package leetcode.leetcode14xx.leetcode1497;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean canArrange(int[] arr, int k) {
        int n = arr.length;
        if (n % 2 != 0) return false;
        if (n == 0 || k == 1) return true;
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int a : arr) {
            int mod = a % k;
            if (mod < 0) mod += k;
            count.put(mod, count.getOrDefault(mod, 0) + 1);
        }

        Integer zeroCount = count.remove(0);
        if (zeroCount != null && zeroCount % 2 != 0) return false;
        if (k % 2 == 0) {
            Integer c = count.remove(k / 2);
            if (c != null && c % 2 != 0) return false;
        }
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (!entry.getValue().equals(count.get(k - entry.getKey()))) return false;
        }
        return true;
    }
}
