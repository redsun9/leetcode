package leetcode.leetcode9xx.leetcode957;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static final int length = 8;

    public int[] prisonAfterNDays(int[] cells, int n) {
        HashMap<Integer, Integer> keyToDay = new HashMap<>();
        List<Integer> dayToKey = new ArrayList<>();
        int[] prev = new int[8];
        compute(cells, prev);
        if (n == 1) return prev;
        int[] next = new int[8];
        int startKey = encode(prev);
        keyToDay.put(startKey, 0);
        dayToKey.add(startKey);

        for (int i = 1; i < n; i++) {
            compute(prev, next);
            int key = encode(next);
            if (keyToDay.containsKey(key)) {
                int period = i - keyToDay.get(key);
                return decode(dayToKey.get((n - 1) % period));
            } else {
                keyToDay.put(key, i);
                dayToKey.add(key);
            }
            int[] tmp = next;
            next = prev;
            prev = tmp;
        }
        return prev;
    }

    private static void compute(int[] prev, int[] next) {
        for (int i = 1; i < length - 1; i++) next[i] = 1 - (prev[i - 1] ^ prev[i + 1]);
    }

    public static int encode(int[] a) {
        int ans = 0;
        for (int i = 1; i < length - 1; i++) ans = (ans << 1) | a[i];
        return ans;
    }

    public static int[] decode(int key) {
        int[] ans = new int[length];
        for (int i = 1; i < length - 1; i++) ans[i] = (key >> (length - 2 - i)) & 1;
        return ans;
    }
}
