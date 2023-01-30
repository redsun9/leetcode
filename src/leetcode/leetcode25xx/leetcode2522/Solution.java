package leetcode.leetcode25xx.leetcode2522;

public class Solution {
    public int minimumPartition(String s, int k) {
        int n = s.length();
        if (n == 0) return 0;
        if (k < 9) {
            for (int i = 0; i < n; i++) if (s.charAt(i) - '0' > k) return -1;
            return n;
        }
        int ans = 1;
        long tmp = 0;
        for (int i = 0; i < n; i++) {
            tmp = tmp * 10 + s.charAt(i) - '0';
            if (tmp > k) {
                ans++;
                tmp = s.charAt(i) - '0';
            }
        }
        return ans;
    }
}
