package leetcode.leetcode37xx.leetcode3767;

import java.util.Arrays;

public class Solution {
    public long maxPoints(int[] technique1, int[] technique2, int k) {
        int n = technique1.length;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.max(technique1[i], technique2[i]);
            technique1[i] -= technique2[i];
        }
        Arrays.sort(technique1);
        for (int i = n - k; i < n; i++) {
            if (technique1[i] < 0) ans += technique1[i];
            else break;
        }
        return ans;
    }
}
