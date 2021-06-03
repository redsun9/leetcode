package leetcode.leetcode3xx.leetcode365;

public class Solution {
    //greatest common divisor
    private static int gcd(int a, int b) {
        int c;
        while (b != 0) {
            a %= b;
            c = a;
            a = b;
            b = c;
        }
        return a;
    }

    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (jug1Capacity + jug2Capacity < targetCapacity) return false;
        int a = gcd(jug1Capacity, jug2Capacity);
        return gcd(a, targetCapacity) == a;
    }
}
