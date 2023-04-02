package leetcode.leetcode25xx.leetcode2555;

public class Solution {
    public int maximizeWin(int[] prizePositions, int k) {
        int n = prizePositions.length;
        if (n <= 2) return n;
        int ans = 2;
        for (int r2 = 1, l2 = 1, l1 = 0, r1 = 0, maxL = 1; r2 < n; r2++) {
            int threshold1 = prizePositions[r2] - k;
            while (prizePositions[l2] < threshold1) l2++;
            while (r1 < l2 - 1) {
                int threshold2 = prizePositions[++r1] - k;
                while (prizePositions[l1] < threshold2) l1++;
                maxL = Math.max(maxL, r1 - l1 + 1);
            }
            ans = Math.max(ans, r2 - l2 + 1 + maxL);
        }
        return ans;
    }
}
