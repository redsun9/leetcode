package leetcode.leetcode18xx.leetcode1819;

import java.util.HashSet;

public class Solution {
    private static int gcd(int a, int b) {
        int c;
        while (b != 0) {
            c = a % b;
            a = b;
            b = c;
        }
        return a;
    }

    public int countDifferentSubsequenceGCDs(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int max = 0;
        for (int num : nums) {
            set.add(num);
            max = Math.max(max, num);
        }

        int ans = 1;
        for (int i = 1; i < max; i++) {
            int g = 0;
            for (int j = i; j <= max; j += i) {
                if (set.contains(j)) g = gcd(g, j);
                if (g == i) break;
            }
            if (g == i) ans++;
        }
        return ans;

    }
}
