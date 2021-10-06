package leetcode.leetcode3xx.leetcode360;

import java.util.Arrays;

@SuppressWarnings("DuplicatedCode")
public class Solution {
    /**
     * @param nums: a sorted array
     * @param a:
     * @param b:
     * @param c:
     * @return a sorted array
     */
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int[] ans = new int[n];
        if (a == 0) {
            if (b == 0) Arrays.fill(ans, c);
            else {
                for (int i = 0; i < n; i++) ans[i] = b * nums[i] + c;
                if (b < 0) {
                    for (int i = 0, j = n - 1; i < j; i++, j--) {
                        int tmp = ans[i];
                        ans[i] = ans[j];
                        ans[j] = tmp;
                    }
                }

            }
        } else {
            if (a > 0) {
                for (
                        int i = n - 1, j1 = 0, j2 = n - 1, val1 = f(nums[0], a, b, c), val2 = f(nums[n - 1], a, b, c);
                        i >= 0; i--
                ) {
                    if (val1 >= val2) {
                        ans[i] = val1;
                        if (++j1 != n) val1 = f(nums[j1], a, b, c);
                        else val1 = Integer.MIN_VALUE;
                    } else {
                        ans[i] = val2;
                        if (--j2 != -1) val2 = f(nums[j2], a, b, c);
                        else val1 = Integer.MIN_VALUE;
                    }
                }
            } else {
                for (
                        int i = 0, j1 = 0, j2 = n - 1, val1 = f(nums[0], a, b, c), val2 = f(nums[n - 1], a, b, c);
                        i < n; i++
                ) {
                    if (val1 <= val2) {
                        ans[i] = val1;
                        if (++j1 != n) val1 = f(nums[j1], a, b, c);
                        else val1 = Integer.MAX_VALUE;
                    } else {
                        ans[i] = val2;
                        if (--j2 != -1) val2 = f(nums[j2], a, b, c);
                        else val1 = Integer.MAX_VALUE;
                    }
                }
            }
        }
        return ans;
    }

    private static int f(int x, int a, int b, int c) {
        return (a * x + b) * x + c;
    }
}
