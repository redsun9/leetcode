package leetcode.leetcode9xx.leetcode974;

import java.util.HashMap;

public class Solution {
    public int subarraysDivByK(int[] arr, int k) {
        int n = arr.length;
        if (n == 0) return 0;
        if (k == 1) return n * (n + 1) / 2;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int ans = 0;
        int sum = 0;
        for (int a : arr) {
            sum = (sum + a) % k;
            if (sum < 0) sum += k;
            ans += map.compute(sum, (key, value) -> value == null ? 1 : value + 1);
        }
        return ans - n;
    }
}
