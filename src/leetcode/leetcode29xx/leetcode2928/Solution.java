package leetcode.leetcode29xx.leetcode2928;

public class Solution {
    public int distributeCandies(int n, int l) {
        n = Math.min(n, 3 * l - n);
        if (n < 0) return 0;
        else if (n <= l) return (n + 1) * (n + 2) / 2;
        else return (l + 1) * (l + 1) - (2 * l - n) * (2 * l - n + 1) / 2 - (n - l) * (n - l + 1) / 2;
    }
}
