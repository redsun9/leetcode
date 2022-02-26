package leetcode.leetcode21xx.leetcode2171;

import java.util.Arrays;

public class Solution {
    public long minimumRemoval(int[] beans) {
        int n = beans.length;
        if (n <= 1) return 0;

        Arrays.sort(beans);
        long total = 0;
        for (int bean : beans) total += bean;

        long maxBeanLeft = 0;
        for (int i = 0, bags = n; i < n; i++, bags--) maxBeanLeft = Math.max(maxBeanLeft, (long) bags * beans[i]);
        return total - maxBeanLeft;
    }
}
