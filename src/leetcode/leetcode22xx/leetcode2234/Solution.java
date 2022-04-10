package leetcode.leetcode22xx.leetcode2234;

import java.util.Arrays;

public class Solution {
    public long maximumBeauty(int[] flowers, long newFlowers, int target, long full, long partial) {
        int n = flowers.length;
        Arrays.sort(flowers);
        while (n > 0 && flowers[n - 1] >= target) n--;
        long alreadyFull = full * (flowers.length - n);
        if (n == 0) return alreadyFull;

        long sumToCompleteAll = (long) target * n;
        for (int i = 0; i < n; i++) sumToCompleteAll -= flowers[i];
        if (sumToCompleteAll - 1 <= newFlowers) {
            long possibleResult = (n - 1) * full + partial * (target - 1);
            if (sumToCompleteAll <= newFlowers) return alreadyFull + Math.max(possibleResult, n * full);
            else return possibleResult;
        }

        long leftSpent = 0, rightSpent = 0;
        int leftIdx = 1, rightIdx = n;
        while (leftIdx < n && newFlowers >= leftSpent + (long) leftIdx * (flowers[leftIdx] - flowers[leftIdx - 1])) {
            leftSpent += (long) leftIdx * (flowers[leftIdx] - flowers[leftIdx - 1]);
            leftIdx++;
        }
        long ans = partial * (flowers[leftIdx - 1] + (newFlowers - leftSpent) / leftIdx);

        while (rightSpent + target - flowers[--rightIdx] <= newFlowers) {
            rightSpent += target - flowers[rightIdx];
            while (leftIdx > rightIdx || leftSpent + rightSpent > newFlowers) {
                leftIdx--;
                leftSpent -= (long) leftIdx * (flowers[leftIdx] - flowers[leftIdx - 1]);
            }
            ans = Math.max(ans, (n - rightIdx) * full + partial * (flowers[leftIdx - 1] + (newFlowers - leftSpent - rightSpent) / leftIdx));
        }
        return alreadyFull + ans;
    }
}
