package leetcode.leetcode20xx.leetcode2094;

import java.util.Arrays;

public class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] count = new int[10];
        for (int digit : digits) count[digit]++;
        for (int i = 0; i < 10; i++) count[i] = Math.min(count[i], 3);

        int[] ans = new int[1000];
        int total = 0;

        for (int a = 1; a < 10; a++) {
            if (count[a] == 0) continue;
            count[a]--;
            for (int b = 0; b < 10; b++) {
                if (count[b] == 0) continue;
                count[b]--;
                for (int c = 0; c < 10; c += 2) {
                    if (count[c] == 0) continue;
                    ans[total++] = a * 100 + b * 10 + c;
                }
                count[b]++;
            }
            count[a]++;
        }
        return Arrays.copyOfRange(ans, 0, total);
    }
}
