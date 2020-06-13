package leetcode.leetcode13xx.leetcode1338;

import java.util.HashMap;

public class Solution {
    public int minSetSize(int[] arr) {
        int n = arr.length;
        if (n <= 2) return (n + 1) / 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int a : arr) map.put(a, map.getOrDefault(a, 0) + 1);
        int[] count = new int[n + 1];
        for (Integer value : map.values()) count[value]++;
        n = (n + 1) / 2;
        int ans = 0;
        for (int i = arr.length; i > 0; i--) {
            if (count[i] != 0) {
                int tmp = Math.min(count[i], (n + (i - 1)) / i);
                ans += tmp;
                n -= i * tmp;
                if (n <= 0) break;
            }
        }
        return ans;
    }
}
