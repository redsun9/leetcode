package leetcode.leetcode497;

import java.util.Arrays;
import java.util.Random;

public class Solution {
    private final Random random;
    private int[][] rects;
    private final int[] s;
    private final int totalS;

    public Solution(int[][] rects) {
        this.rects = rects;
        int n = rects.length;
        this.s = new int[n];
        s[0] = (rects[0][2] - rects[0][0] + 1) * (rects[0][3] - rects[0][1] + 1) - 1;
        for (int i = 1; i < n; i++) {
            s[i] = s[i - 1] + (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1);
        }
        totalS = s[n - 1] + 1;
        random = new Random();
    }

    public int[] pick() {
        int[] ans = new int[2];
        int pos = Arrays.binarySearch(s, random.nextInt(totalS));
        if (pos < 0) pos = -pos - 1;
        int[] rect = rects[pos];
        ans[0] = rect[0] + random.nextInt(rect[2] - rect[0] + 1);
        ans[1] = rect[1] + random.nextInt(rect[3] - rect[1] + 1);
        return ans;
    }
}
