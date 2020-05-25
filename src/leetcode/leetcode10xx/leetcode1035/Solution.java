package leetcode.leetcode10xx.leetcode1035;

public class Solution {
    public int maxUncrossedLines(int[] a, int[] b) {
        int m = a.length, n = b.length;
        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];
        for (int value : a) {
            for (int j = 0; j < n; j++) {
                if (value == b[j])
                    curr[j + 1] = 1 + prev[j];
                else
                    curr[j + 1] = Math.max(curr[j], prev[j + 1]);
            }
            int[] tmp = curr;
            curr = prev;
            prev = tmp;
        }
        return prev[n];
    }
}
