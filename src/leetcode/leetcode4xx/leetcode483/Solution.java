package leetcode.leetcode4xx.leetcode483;

public class Solution {
    public String smallestGoodBase(String n) {
        long num = Long.parseLong(n);
        for (int d = (int) (Math.log(num + 1) / Math.log(2)); d > 2; d--) {
            long lo = (long) (Math.pow(num + 1, 1.0 / d));
            long hi = (long) (Math.pow(num, 1.0 / (d - 1)));

            while (lo <= hi) {
                long mid = lo + (hi - lo) / 2;
                long f = 0;
                for (int i = 0; i < d; i++) f = f * mid + 1;
                if (num == f) return String.valueOf(mid);
                else if (num < f) hi = mid - 1;
                else lo = mid + 1;
            }
        }
        return String.valueOf(num - 1);
    }
}
