package leetcode.leetcode9xx.leetcode944;

public class Solution {
    public int minDeletionSize(String[] a) {
        int n = a.length;
        if (n <= 1) return 0;
        int m = a[0].length();
        int ans = 0;
        for (int i = 0; i < m; i++) {
            boolean shouldRemove = false;
            char prev = a[0].charAt(i), curr;
            for (int j = 1; j < n; j++) {
                curr = a[j].charAt(i);
                if (prev > curr) {
                    shouldRemove = true;
                    break;
                }
                prev = curr;
            }
            if (shouldRemove) ans++;
        }
        return ans;
    }
}
