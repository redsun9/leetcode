package leetcode.leetcode6xx.leetcode633;

public class Solution {
    public boolean judgeSquareSum(int c) {
        if (c < 3) return true;
        while (c % 2 == 0) c /= 2;
        int top = (int) Math.round(Math.sqrt(c)) + 1;
        for (int i = 3; i <= top; i += 2) {
            int t = 0;
            while (c % i == 0) {
                t++;
                c /= i;
            }
            if (i % 4 == 3 && t % 2 == 1) return false;
            if (t != 0) top = (int) Math.round(Math.sqrt(c)) + 1;
        }
        return c % 4 != 3;
    }
}
