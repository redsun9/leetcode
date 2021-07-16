package leetcode.leetcode17xx.leetcode1718;

public class Solution {
    private static boolean bt(int pos, int n, int maxPos, int key, int[] ans) {
        if (key == 0) return true;
        while (pos <= 2 * n - 2 && ans[pos] != 0) pos++;
        if (pos == maxPos) return false;
        for (int i = n; i >= 2; i--) {
            if (pos + i < maxPos && ans[pos] == 0 && ans[pos + i] == 0 && (key & 1 << i - 1) != 0) {
                ans[pos] = i;
                ans[pos + i] = i;
                if (bt(pos + 1, n, maxPos, key ^ 1 << i - 1, ans)) return true;
                ans[pos] = 0;
                ans[pos + i] = 0;
            }
        }
        if ((key & 1) != 0) {
            ans[pos] = 1;
            if (bt(pos + 1, n, maxPos, key ^ 1, ans)) return true;
            ans[pos] = 0;
        }
        return false;
    }

    public int[] constructDistancedSequence(int n) {
        int[] ans = new int[2 * n - 1];
        bt(0, n, 2 * n - 1, (1 << n) - 1, ans);
        return ans;
    }
}
