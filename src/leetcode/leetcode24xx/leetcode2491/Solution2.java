package leetcode.leetcode24xx.leetcode2491;

public class Solution2 {
    public static final int MAX_VAL = 1000;

    public long dividePlayers(int[] skill) {
        int[] cnt = new int[MAX_VAL + 1];
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int val : skill) cnt[val]++;
        for (int val : skill) min = Math.min(min, val);
        for (int val : skill) max = Math.max(max, val);

        long ans = 0;
        for (int i = min, j = max; i < j; i++, j--) {
            if (cnt[i] != cnt[j]) return -1;
            ans += (long) cnt[i] * j * i;
        }
        if ((min + max) % 2 == 0) {
            int mid = (min + max) / 2;
            ans += cnt[mid] / 2L * mid * mid;
        }
        return ans;
    }
}
