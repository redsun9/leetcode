package leetcode.leetcode7xx.leetcode754;

public class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int x = (int) ((Math.sqrt(8L * target + 1) - 1) / 2);
        int t = x * (x + 1) / 2;
        if (t == target) return x;
        do {
            x++;
            t += x;
        } while (((t - target) & 1) != 0);
        return x;
    }
}
