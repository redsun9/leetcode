package leetcode.leetcode10xx.leetcode1015;

public class Solution {
    public int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0) return -1;
        if (k == 1) return 1;
        int n = 1;
        int tmp = 1;
        while (tmp != 0) {
            n++;
            tmp = (tmp * 10 + 1) % k;
        }
        return n;
    }
}
