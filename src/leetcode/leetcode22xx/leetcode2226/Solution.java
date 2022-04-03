package leetcode.leetcode22xx.leetcode2226;

public class Solution {
    private static final int MAX_PILE = 10_000_000;

    public int maximumCandies(int[] candies, long k) {
        int lo = 0, hi = MAX_PILE;
        while (lo < hi) {
            int mid = (lo + hi + 1) / 2;
            if (check(candies, mid, k)) lo = mid;
            else hi = mid - 1;
        }
        return lo;
    }

    private static boolean check(int[] candies, int val, long k) {
        for (int candy : candies) k -= candy / val;
        return k <= 0;
    }
}
