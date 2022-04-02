package leetcode.leetcode22xx.leetcode2221;

public class Solution {
    private static final int[] powerOfTwoMod = {6, 2, 4, 8}; // 1, 2, 4, 8, 16, 32, 64,...
    private static final int[] reverseMods = {-1, 1, -1, 7, -1, -1, -1, 3, -1, 9}; // 1*1,3*7,7*3,9*9

    public int triangularSum(int[] nums) {
        int ans = 0;
        int currMultiplierMod = 1, twoPower = 0, fivePower = 0, i = 1, j = nums.length - 1, tmp;

        for (int num : nums) {
            int mod = calculateMod(num * currMultiplierMod, twoPower, fivePower);
            ans += mod;

            tmp = j;
            if (j == 0) break;
            while ((tmp & 1) == 0) {
                tmp >>>= 1;
                twoPower++;
            }
            while (tmp % 5 == 0) {
                tmp /= 5;
                fivePower++;
            }
            currMultiplierMod = currMultiplierMod * tmp % 10;

            tmp = i;
            while ((tmp & 1) == 0) {
                tmp >>>= 1;
                twoPower--;
            }
            while (tmp % 5 == 0) {
                tmp /= 5;
                fivePower--;
            }
            currMultiplierMod = currMultiplierMod * reverseMods[tmp % 10];

            i++;
            j--;
        }
        return ans % 10;
    }

    private static int calculateMod(int num, int twoPower, int fivePower) {
        if (num == 0) return 0;
        while ((num & 1) == 0) {
            num >>>= 1;
            twoPower++;
        }
        while (num % 5 == 0) {
            num /= 5;
            fivePower++;
        }

        if (twoPower != 0 && fivePower != 0) return 0;
        if (fivePower != 0) return num * 5 % 10;
        if (twoPower != 0) return num * powerOfTwoMod[twoPower % 4] % 10;
        return num % 10;
    }
}
