package leetcode.leetcode25xx.leetcode2550;

public class Solution {
    private static final int MOD = 1_000_000_007;

    public int monkeyMove(int n) {
        int ans = powMod(n) - 2;
        if (ans < 0) ans += MOD;
        return ans;
    }


    private static int powMod(int b) {
        int a = 2;
        long res = 1;
        while (b != 0)
            if ((b & 1) != 0) {
                res = (res * a) % MOD;
                --b;
            } else {
                a = (int) (((long) a * a) % MOD);
                b >>= 1;
            }
        return (int) res;
    }
}
