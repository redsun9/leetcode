package leetcode.leetcode25xx.leetcode2565;

public class Solution {
    public int minimumScore(String s, String t) {
        int m = s.length(), n = t.length();

        int[] left = new int[n];
        int maxLeft = 0;
        int i = 0;
        while (maxLeft < n && i < m) {
            if (s.charAt(i) == t.charAt(maxLeft)) left[maxLeft++] = i;
            i++;
        }
        if (maxLeft == n) return 0;

        int[] right = new int[n];
        int maxRight = 0;
        int j = m - 1;
        while (maxRight < n && j >= 0) {
            if (s.charAt(j) == t.charAt(n - 1 - maxRight)) right[maxRight++] = j;
            j--;
        }
        int ans = n - Math.max(maxLeft, maxRight);
        int c2 = maxRight;
        for (int c1 = 1; c1 <= maxLeft; c1++) {
            while (c2 > 0 && left[c1 - 1] >= right[c2 - 1]) c2--;
            ans = Math.min(ans, n - c1 - c2);
        }
        return ans;
    }
}
