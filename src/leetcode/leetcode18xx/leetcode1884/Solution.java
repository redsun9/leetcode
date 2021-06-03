package leetcode.leetcode18xx.leetcode1884;

public class Solution {
    public int twoEggDrop(int n) {
        int x = (int) Math.round((-1 + Math.sqrt(1 + 8 * n)) / 2);
        if (x * (x + 1) / 2 < n) x++;
        return x;
    }
}
