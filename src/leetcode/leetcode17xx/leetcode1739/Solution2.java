package leetcode.leetcode17xx.leetcode1739;

public class Solution2 {
    //Solution from Lee
    // It is accepted by leetcode, but fails for many cases
    public int minimumBoxes(int n) {
        if (n <= 3) return n;
        long i = (long) (Math.cbrt(n * 6L)) - 1;
        long floor = i * (i + 1) / 2L, sum = (i + 2) * (i + 1) * i / 6L;
        long diff = n - sum;
        //Quadratic formula
        double f = (-1 + Math.sqrt(1 + 4 * 2 * diff)) / 2;
        return (int) floor + (int) Math.ceil(f);
    }
}
