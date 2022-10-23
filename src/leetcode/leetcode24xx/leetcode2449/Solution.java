package leetcode.leetcode24xx.leetcode2449;

import java.util.Arrays;

public class Solution {
    public long makeSimilar(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        long ans = 0;
        int i = 0, j = 0, n = a.length;
        while (true) {
            while (i < n && (a[i] & 1) != 0) i++;
            if (i == n) break;
            while (j < n && (b[j] & 1) != 0) j++;
            ans += Math.abs(a[i++] - b[j++]);
        }
        i = 0;
        j = 0;
        while (true) {
            while (i < n && (a[i] & 1) == 0) i++;
            if (i == n) break;
            while (j < n && (b[j] & 1) == 0) j++;
            ans += Math.abs(a[i++] - b[j++]);
        }
        return ans >> 2;

    }
}
