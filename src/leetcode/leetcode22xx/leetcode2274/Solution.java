package leetcode.leetcode22xx.leetcode2274;

import java.util.Arrays;

public class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        int max = 0, n = special.length;
        if (n == 0) return top - bottom + 1;
        Arrays.sort(special);
        int ans = Math.max(special[0] - bottom, top - special[n - 1]);
        for (int i = 1; i < n; i++) ans = Math.max(ans, Math.max(ans, special[i] - special[i - 1] - 1));
        return ans;
    }
}
