package leetcode.leetcode37xx.leetcode3783;

class Solution {
    public int mirrorDistance(int n) {
        int tmp1 = n, tmp2 = 0;
        while (tmp1 != 0) {
            tmp2 = tmp2 * 10 + tmp1 % 10;
            tmp1 /= 10;
        }
        return Math.abs(n - tmp2);
    }
}
