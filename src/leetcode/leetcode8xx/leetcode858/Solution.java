package leetcode.leetcode8xx.leetcode858;

public class Solution {
    public int mirrorReflection(int p, int q) {
        int r = gcd(p, q);
        return (1 - ((p / r) & 1)) + ((q / r) & 1);
    }


    //greatest common divisor
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
