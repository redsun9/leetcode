package leetcode.leetcode37xx.leetcode3747;

public class Solution {
    public long countDistinct(long n) {
        long ans = 0;
        long power = 1;
        long nines = 1;
        while (power * 10 <= n) {
            power *= 10;
            nines *= 9;
            ans += nines;
        }
        boolean ok = true;
        while (power != 0 && ok) {
            int digit = (int) (n / power % 10);
            if (digit >= 2) ans += (digit - 1) * nines;
            if (digit == 0) ok = false;
            power /= 10;
            nines /= 9;
        }
        if (ok) ans++;
        return ans;
    }
}
