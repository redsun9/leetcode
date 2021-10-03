package leetcode.leetcode20xx.leetcode2024;

public class Solution {
    public int maxConsecutiveAnswers(String s, int k) {
        int n = s.length();
        if (n / 2 <= k) return n;
        int ans = Math.min(n, 2 * k + 1);

        for (int l = 0, r = 0, c = 0; r < n; r++) {
            if (s.charAt(r) == 'F') c++;
            while (c > k) if (s.charAt(l++) == 'F') c--;
            ans = Math.max(ans, r - l + 1);
        }
        for (int l = 0, r = 0, c = 0; r < n; r++) {
            if (s.charAt(r) == 'T') c++;
            while (c > k) if (s.charAt(l++) == 'T') c--;
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
