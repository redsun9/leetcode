package leetcode.leetcode10xx.leetcode1024;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int videoStitching(int[][] clips, int t) {
        if (t == 0) return 0;
        int n = clips.length;
        if (n == 0) return -1;
        Arrays.sort(clips, Comparator.comparingInt(x -> x[0]));
        int ans = 0;
        int leftBorder = 0;
        int i = 0;
        while (i < n && leftBorder < t) {
            if (clips[i][0] > leftBorder) return -1;
            int maxRight = clips[i][0];
            while (i < n && clips[i][0] <= leftBorder) {
                maxRight = Math.max(maxRight, clips[i][1]);
                i++;
            }
            ans++;
            leftBorder = maxRight;
        }
        if (leftBorder < t) return -1;
        return ans;
    }
}
