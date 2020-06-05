package leetcode.leetcode5xx.leetcode528;

import java.util.Arrays;
import java.util.Random;

public class Solution2 {
    private final Random random;
    private final int[] w;

    public Solution2(int[] w) {
        random = new Random();
        this.w = w;
        for (int i = 1; i < w.length; i++) w[i] += w[i - 1];
    }

    public int pickIndex() {
        int ans = Arrays.binarySearch(w, 1 + random.nextInt(w[w.length - 1]));
        if (ans < 0) ans = -ans - 1;
        return ans;
    }
}
