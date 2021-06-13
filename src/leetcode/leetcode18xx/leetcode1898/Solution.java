package leetcode.leetcode18xx.leetcode1898;

import java.util.Arrays;

public class Solution {
    private static boolean check(String p, int[][] nextPos, int[] removedAt, int val) {
        int m = p.length();
        int i = 0;
        int pos = nextPos[0][p.charAt(0) - 'a'];
        while (pos != -1) {
            if (removedAt[pos] == -1 || removedAt[pos] >= val) {
                if (++i == m) return true;
            }
            pos = nextPos[pos + 1][p.charAt(i) - 'a'];
        }
        return false;
    }

    public int maximumRemovals(String s, String p, int[] removable) {
        int n = s.length();

        int[][] nextPos = new int[n + 1][26];
        Arrays.fill(nextPos[n], -1);
        for (int i = n - 1; i >= 0; i--) {
            System.arraycopy(nextPos[i + 1], 0, nextPos[i], 0, 26);
            nextPos[i][s.charAt(i) - 'a'] = i;
        }

        int[] removedAt = new int[n];
        Arrays.fill(removedAt, -1);
        for (int i = 0; i < removable.length; i++) {
            removedAt[removable[i]] = i;
        }

        int lo = 0, hi = removable.length;
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            if (check(p, nextPos, removedAt, mid)) lo = mid;
            else hi = mid - 1;
        }
        return lo;
    }
}
