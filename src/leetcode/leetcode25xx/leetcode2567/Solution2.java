package leetcode.leetcode25xx.leetcode2567;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;
import static java.lang.Math.min;

@SuppressWarnings("DuplicatedCode")
public class Solution2 {
    public int minimizeSum(int[] nums) {
        int n = nums.length;
        if (n <= 3) return 0;
        int[] minThree = minThree(nums);
        int[] maxThree = maxThree(nums);
        return min(maxThree[0] - minThree[2], min(maxThree[1] - minThree[1], maxThree[2] - minThree[0]));
    }

    private static int[] minThree(int[] nums) {
        int min1 = MAX_VALUE, min2 = MAX_VALUE, min3 = MAX_VALUE;
        for (int num : nums) {
            if (num < min1) {
                min3 = min2;
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min3 = min2;
                min2 = num;
            } else if (num < min3) {
                min3 = num;
            }
        }
        return new int[]{min1, min2, min3};
    }

    private static int[] maxThree(int[] nums) {
        int max1 = MIN_VALUE, max2 = MIN_VALUE, max3 = MIN_VALUE;
        for (int num : nums) {
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }
        }
        return new int[]{max1, max2, max3};
    }
}
