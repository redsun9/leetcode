package leetcode.leetcode7xx.leetcode762;

public class Solution {
    public int countPrimeSetBits(int l, int r) {
        boolean[] prime = new boolean[20];
        prime[2] = true;
        prime[3] = true;
        prime[5] = true;
        prime[7] = true;
        prime[11] = true;
        prime[13] = true;
        prime[17] = true;
        prime[19] = true;
        int ans = 0;
        for (int i = l; i <= r; i++) {
            if (prime[Integer.bitCount(i)]) ans++;
        }
        return ans;
    }
}
