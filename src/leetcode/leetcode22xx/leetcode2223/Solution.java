package leetcode.leetcode22xx.leetcode2223;

@SuppressWarnings("DuplicatedCode")
public class Solution {
    public long sumScores(String s) {
        int[] arr = zFunction(s);
        long ans = arr.length;
        for (int a : arr) ans += a;
        return ans;
    }

    private static int[] zFunction(String s) {
        int n = s.length();
        int[] zf = new int[n];
        int left = 0, right = 0;
        for (int i = 1; i < n; i++) {
            zf[i] = Math.max(0, Math.min(right - i, zf[i - left]));
            while (i + zf[i] < n && s.charAt(zf[i]) == s.charAt(i + zf[i])) zf[i]++;
            if (i + zf[i] > right) {
                left = i;
                right = i + zf[i];
            }
        }
        return zf;
    }
}
