package leetcode.leetcode22xx.leetcode2272;

// Space: O(k*n), n - length of s, k - ALPHABET_SIZE
// Time: O(k*n^2)
public class Solution {
    private static final int ALPHABET_SIZE = 26;

    public int largestVariance(String s) {
        int n = s.length();
        int[][] count = new int[n + 1][ALPHABET_SIZE];
        for (int i = 0; i < n; i++) {
            System.arraycopy(count[i], 0, count[i + 1], 0, ALPHABET_SIZE);
            count[i + 1][s.charAt(i) - 'a']++;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 2; j <= n; j++) {
                int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
                for (int k = 0; k < ALPHABET_SIZE; k++) {
                    int cnt = count[j][k] - count[i][k];
                    if (cnt == 0) continue;
                    min = Math.min(min, cnt);
                    max = Math.max(max, cnt);
                }
                ans = Math.max(ans, max - min);
            }
        }
        return ans;
    }
}
