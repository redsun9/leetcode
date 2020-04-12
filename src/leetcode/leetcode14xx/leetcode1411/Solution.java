package leetcode.leetcode14xx.leetcode1411;

public class Solution {
    private static final int m = 1_000_000_007;

    public int numOfWays(int n) {
        long aba = 6;
        long abc = 6;
        for (int i = 2; i <= n; i++) {
            long tabc = 2 * (aba + abc) % m;
            long taba = (3 * aba + 2 * abc) % m;
            aba = taba;
            abc = tabc;
        }
        return (int) (aba + abc) % m;
    }
}
