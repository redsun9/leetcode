package leetcode.leetcode39xx.leetcode3932;

public class Solution {
    public int countKthRoots(int l, int r, int k) {
        return sqrt(r, k) - sqrt(l - 1, k);
    }

    private static int sqrt(int num, int k) {
        if (num <= 1) return num;
        int ans = (int) Math.round(Math.exp(Math.log(num) / k));
        if (num < binPow(ans, k)) ans--;
        return ans;
    }

    //a^n
    private static long binPow(int a, int n) {
        long res = 1;
        long tmp = a;
        while (n != 0) {
            if ((n & 1) != 0)
                res *= tmp;
            tmp *= tmp;
            n >>= 1;
        }
        return res;
    }
}
