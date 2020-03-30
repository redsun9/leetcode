package leetcode.leetcode528;

import java.util.Arrays;
import java.util.Random;

public class Solution {
    private int[] s;
    private Random random;
    private final int total;

    public Solution(int[] w) {
        int n = w.length;
        s = new int[n];
        s[0] = w[0] - 1;
        for (int i = 1; i < n; i++) {
            s[i] = s[i - 1] + w[i];
        }
        total = s[n - 1] + 1;
        random = new Random();
    }

    public int pickIndex() {
        int ans = Arrays.binarySearch(s, random.nextInt(total));
        if (ans < 0) ans = -ans - 1;
        return ans;
    }
}
