package leetcode.leetcode8xx.leetcode875;

public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1, hi = (int) 1e9;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (check(piles, mid, h)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    private static boolean check(int[] piles, int k, int h) {
        for (int pile : piles) h -= (pile + k - 1) / k;
        return h >= 0;
    }
}
