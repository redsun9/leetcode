package leetcode.leetcode25xx.leetcode2517;

import java.util.Arrays;

public class Solution {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int lo = 0, hi = (price[price.length - 1] - price[0]) / (k - 1);
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            if (check(price, k, mid)) lo = mid;
            else hi = mid - 1;
        }
        return lo;

    }

    private static boolean check(int[] price, int k, int val) {
        int n = price.length;
        int prev = price[0];
        k--;
        for (int p : price) {
            if (p - prev >= val) {
                if (--k == 0) return true;
                prev = p;
            }
        }
        return false;
    }
}
