package leetcode.leetcode23xx.leetcode2300;

import java.util.Arrays;

public class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int m = potions.length, n = spells.length;
        Arrays.sort(potions);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            long threshold = (success + spells[i] - 1) / spells[i];
            int l = 0, r = m;
            while (l < r) {
                int mid = (l + r) / 2;
                if (potions[mid] >= threshold) r = mid;
                else l = mid + 1;
            }
            ans[i] = m - r;
        }
        return ans;
    }
}
