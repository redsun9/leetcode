package leetcode.leetcode21xx.leetcode2105;

public class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int ans = 0, n = plants.length;

        int c1 = capacityA, end1 = n / 2;
        for (int i = 0; i < end1; i++) {
            if (c1 < plants[i]) {
                ans++;
                c1 = capacityA;
            }
            c1 -= plants[i];
        }

        int c2 = capacityB, end2 = n - n / 2;
        for (int i = n - 1; i >= end2; i--) {
            if (c2 < plants[i]) {
                ans++;
                c2 = capacityB;
            }
            c2 -= plants[i];
        }

        if ((n & 1) != 0 && c1 < plants[end1] && c2 < plants[end1]) ans++;
        return ans;
    }
}
