package leetcode.leetcode9xx.leetcode932;

import java.util.Arrays;

public class Solution2 {
    public int[] beautifulArray(int n) {
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) ans[i] = Integer.reverse(i + 1) >>> 1;
        Arrays.sort(ans);
        for (int i = 0; i < n; i++) ans[i] = Integer.reverse(ans[i] << 1);
        return ans;
    }
}
