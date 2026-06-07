package leetcode.leetcode38xx.leetcode3854;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;
import static java.lang.Math.*;

public class Solution {
    public int[] makeParityAlternating(int[] nums) {
        if (nums.length <= 1) return new int[]{0, 0};
        int[] ans1 = makeParityAlternating(nums, 0);
        int[] ans2 = makeParityAlternating(nums, 1);
        return ans1[0] < ans2[0] || ans1[0] == ans2[0] && ans1[1] <= ans2[1] ? ans1 : ans2;
    }

    private static int[] makeParityAlternating(int[] nums, int parityShift) {
        int alternating = 0;
        int minOk = MAX_VALUE, maxOk = MIN_VALUE, minWrong = MAX_VALUE, maxWrong = MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == ((i ^ parityShift) & 1)) {
                minOk = min(minOk, nums[i]);
                maxOk = max(maxOk, nums[i]);
            } else {
                minWrong = min(minWrong, nums[i]);
                maxWrong = max(maxWrong, nums[i]);
                alternating++;
            }
        }
        int diff;
        if (minOk == MAX_VALUE) diff = abs(maxWrong - minWrong - 2);
        else if (minWrong == MAX_VALUE) diff = maxOk - minOk;
        else diff = min3(
                    abs(max3(maxOk, minWrong + 1, maxWrong + 1) - min3(minOk, minWrong + 1, maxWrong + 1)),
                    abs(max3(maxOk, minWrong + 1, maxWrong - 1) - min3(minOk, minWrong + 1, maxWrong - 1)),
                    abs(max3(maxOk, minWrong - 1, maxWrong - 1) - min3(minOk, minWrong - 1, maxWrong - 1))
            );
        return new int[]{alternating, Math.max(diff, 1)};
    }

    private static int max3(int a, int b, int c) {
        return max(max(a, b), c);
    }

    private static int min3(int a, int b, int c) {
        return min(min(a, b), c);
    }
}
