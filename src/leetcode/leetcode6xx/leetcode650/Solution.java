package leetcode.leetcode6xx.leetcode650;

public class Solution {
    public int minSteps(int n) {
        if (n == 1) return 0;
        int ans = 0;
        while ((n & 1) == 0) {
            ans += 2;
            n >>>= 1;
        }
        int prime = 3;
        while (prime * prime <= n) {
            while (n % prime == 0) {
                ans += prime;
                n /= prime;
            }
            prime += 2;
        }
        if (n != 1) ans += n;
        return ans;
    }
}
