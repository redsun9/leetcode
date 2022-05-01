package leetcode.leetcode22xx.leetcode2260;

public class Solution2 {
    private static final int MAX_VAL = 1_000_000;

    public int minimumCardPickup(int[] cards) {
        int[] map = new int[MAX_VAL + 1];
        int ans = Integer.MAX_VALUE;
        int n = cards.length;
        for (int i = 0; i < n; i++) {
            int card = cards[i];
            int prev = map[card];
            if (prev != 0) ans = Math.min(ans, i - prev + 2);
            map[card] = i + 1;
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
