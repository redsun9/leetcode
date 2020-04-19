package leetcode.leetcode14xx.leetcode1414;

public class Solution {
    private static final int[] fib = new int[45];

    static {
        fib[0] = 1;
        fib[1] = 2;
        for (int i = 2; i < 45; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
    }

    public int findMinFibonacciNumbers(int k) {
        int i = 44;
        int ans = 0;
        while (k != 0) {
            while (fib[i] > k) i--;
            k -= fib[i];
            ans++;
        }
        return ans;
    }
}
