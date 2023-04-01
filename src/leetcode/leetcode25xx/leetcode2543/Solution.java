package leetcode.leetcode25xx.leetcode2543;

public class Solution {
    public boolean isReachable(int targetX, int targetY) {
        int gcd = gcd(targetX, targetY);
        return (gcd & (gcd - 1)) == 0;
    }

    private static int gcd(int a, int b) {
        int c;
        while (b != 0) {
            c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
}
