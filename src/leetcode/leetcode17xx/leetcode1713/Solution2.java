package leetcode.leetcode17xx.leetcode1713;

import java.util.HashMap;
import java.util.Map;

//using lis
// O (M*logN), M - length of arr, N - length of target
public class Solution2 {
    public int minOperations(int[] target, int[] arr) {
        int n = target.length;
        int[] dp = new int[n + 1];
        int ans = 0;
        int lo, hi, mid;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(target[i], i);
        for (int a : arr) {
            Integer pos = map.get(a);
            if (pos != null) {
                if (ans == 0 || dp[ans - 1] < pos) dp[ans++] = pos;
                else {
                    lo = 0;
                    hi = ans - 1;
                    while (lo < hi) {
                        mid = lo + (hi - lo) / 2;
                        if (dp[mid] < pos) lo = mid + 1;
                        else hi = mid;
                    }
                    dp[lo] = pos;
                }
            }
        }
        return n - ans;
    }
}
