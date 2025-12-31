package leetcode.leetcode37xx.leetcode3790;

public class Solution {
    public int minAllOneMultiple(int k) {
        if (k % 2 == 0 || k % 5 == 0) return -1;
        long rem = 1 % k;
        int cnt = 1;
        while (rem != 0) {
            rem = (rem * 10 + 1) % k;
            cnt++;
        }
        return cnt;
    }
}
