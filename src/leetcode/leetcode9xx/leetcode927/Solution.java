package leetcode.leetcode9xx.leetcode927;

import java.util.Arrays;

public class Solution {
    public int[] threeEqualParts(int[] a) {
        int[] fail = {-1, -1};
        int n = a.length;
        for (int i = 1; i < n; i++) {
            a[i] += a[i - 1];
        }
        int k = a[n - 1];
        if (k % 3 != 0) return fail;
        if (k == 0) return new int[]{0, 2};

        int start1 = 0;
        while (a[start1] == 0) start1++;
        int end1 = Arrays.binarySearch(a, k / 3);
        int start2 = end1;
        while (end1 > 0 && a[end1 - 1] == a[end1]) end1--;

        while (a[start2 + 1] == a[start2]) start2++;
        start2++;

        int end2 = Arrays.binarySearch(a, k * 2 / 3);
        int start3 = end2;
        while (end2 > 0 && a[end2 - 1] == a[end2]) end2--;
        while (a[start3 + 1] == a[start3]) start3++;
        start3++;
        int end3 = n - 1;
        while (a[end3 - 1] == a[end3]) end3--;

        //[start1,end1] [start2,end2] [start3,end3]
        int trailingZeros = n - end3;
        if (trailingZeros > start2 - end1 || trailingZeros > start3 - end2) return fail;
        int[] ans = {end1 + trailingZeros - 1, end2 + trailingZeros};
        while (start1 < end1 && start2 < end2 && start3 < end3) {
            if (a[end1] - a[start1] != a[end2] - a[start2] || a[end1] - a[start1] != a[end3] - a[start3]) return fail;
            end1--;
            end2--;
            end3--;
        }
        if (start1 == end1 && start2 == end2 && start3 == end3) return ans;
        else return fail;
    }
}
