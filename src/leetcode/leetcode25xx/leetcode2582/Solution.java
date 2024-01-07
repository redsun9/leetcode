package leetcode.leetcode25xx.leetcode2582;

public class Solution {
    public int passThePillow(int n, int time) {
        int mod = time % (2 * (n - 1));
        return mod <= n - 1 ? mod + 1 : 2 * n - 1 - mod;
    }
}
