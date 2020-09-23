package leetcode.leetcode1xx.leetcode135;

import java.util.Arrays;

public class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n <= 1) return n;
        int[] num = new int[n];
        Arrays.fill(num, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) num[i] = num[i - 1] + 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) num[i] = Math.max(num[i + 1] + 1, num[i]);
        }
        int ans = 0;
        for (int a : num) ans += a;
        return ans;
    }
}
